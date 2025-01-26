package agh.ics.oop.model

import main.agh.ics.oop.model.MapDirection


class Animal(var position: Vector2d = Vector2d(2, 2), direction: MapDirection = MapDirection.NORTH){


    var direction: MapDirection = MapDirection.NORTH
        private set


    override fun toString(): String {
        return when(this.direction){
            MapDirection.NORTH -> "^"
            MapDirection.SOUTH -> "v"
            MapDirection.EAST -> ">"
            MapDirection.WEST -> "<"
        }
    }

    public fun isAt(position: Vector2d): Boolean {
        return this.position == position

    }

    public fun move(direction: MoveDirection, validator: WorldMap):Unit{
        when(direction)
        {
            MoveDirection.FORWARD -> {
                val newPosition = this.position + this.direction.toUnitVector()
                if(validator.canMoveTo(newPosition))
                {
                    this.position = newPosition
                }
            }
            MoveDirection.BACKWARD -> {
                val newPosition = this.position - this.direction.toUnitVector()
                if(validator.canMoveTo(newPosition))
                {
                    this.position = newPosition
                }
            }
            MoveDirection.RIGHT -> {
                this.direction = this.direction.next()
            }
            MoveDirection.LEFT -> {
                this.direction = this.direction.previous()
            }

        }

    }




}