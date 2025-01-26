package agh.ics.oop.model

import kotlin.system.exitProcess

class BouncyMap :WorldMap {
    private val animals = HashMap<Vector2d,Animal>()
    private val mapBoundary:Vector2d


    constructor(sizeX : Int=10, sizeY : Int=10)
    {
        this.mapBoundary = Vector2d(sizeX,sizeY)
    }


    override fun canMoveTo(position: Vector2d): Boolean {
        return position.x >= 0 && position.y >= 0 && position.x < this.mapBoundary.x && position.y < this.mapBoundary.y
    }

    override fun objectAt(position: Vector2d): Animal? {
        return this.animals[position]
    }

    override fun place(animal: Animal)
    {
        if(this.canMoveTo(animal.position) && !this.isOccupied(animal.position))
        {
            this.animals[animal.position] = animal
        }
        else if(this.canMoveTo(animal.position) && this.isOccupied(animal.position))
        {
            val newPosition:Vector2d?=this.animals.randomFreePosition(mapBoundary)
            if(newPosition != null)
            {
                animal.position = newPosition
                this.animals[animal.position] = animal
            }
            else
            {
                val newPosition : Vector2d? = this.animals.randomPosition()
                if(newPosition == null)
                {
                    throw IllegalArgumentException("Cannot place animal at ${animal.position}")
                }
                animal.position = newPosition
                this.animals[animal.position] = animal
            }

        }
        else
        {
            throw  IllegalArgumentException("Cannot place animal at ${animal.position}")
        }

    }

    override fun isOccupied(position: Vector2d): Boolean {
        return this.objectAt(position) != null
    }

    override fun move(animal: Animal, direction: MoveDirection) {
        if(!this.animals.containsValue(animal))
        {
            throw IllegalArgumentException("Animal is not on the map")
        }
        val oldPosition = animal.position

        when(direction){
            MoveDirection.LEFT, MoveDirection.RIGHT -> animal.move(direction,this)
            MoveDirection.FORWARD,MoveDirection.BACKWARD->{
                animal.move(direction,this)
                this.animals.remove(oldPosition)
                try{
                    this.place(animal)
                }
                catch (e:IllegalArgumentException)
                {
                    println(e.message)
                    exitProcess(1)
                }

            }

        }

    }


}