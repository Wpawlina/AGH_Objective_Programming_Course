package agh.ics.oop.model

interface WorldMap {
    fun canMoveTo(position: Vector2d): Boolean
    fun place(animal: Animal): Unit
    fun isOccupied(position: Vector2d): Boolean
    fun objectAt(position: Vector2d): Animal?

    fun move(animal: Animal, direction: MoveDirection): Unit



}