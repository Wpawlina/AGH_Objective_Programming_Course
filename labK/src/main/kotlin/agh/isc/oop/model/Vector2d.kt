package agh.ics.oop.model

import main.agh.ics.oop.model.MapDirection

data class Vector2d(val x:Int,  val y: Int)
{
    operator fun compareTo(other : Vector2d): Int {
       return when{
           this.x >= other.x && this.y >= other.y -> 1
              this.x <= other.x && this.y <= other.y -> -1
              else -> 0
       }

    }
    operator  fun unaryMinus(): Vector2d = Vector2d(-this.x, -this.y)


    operator fun plus(other: Vector2d): Vector2d = Vector2d(this.x + other.x, this.y + other.y)


    operator fun minus(other: Vector2d): Vector2d = Vector2d(this.x - other.x, this.y - other.y)


    public fun upperRight(other: Vector2d): Vector2d =Vector2d(Math.max(this.x, other.x), Math.max(this.y, other.y))


    public fun lowerLeft(other: Vector2d): Vector2d =Vector2d(Math.min(this.x, other.x), Math.min(this.y, other.y))







}

fun MapDirection.toUnitVector(): Vector2d {
    return when (this) {
        MapDirection.NORTH -> Vector2d(0, 1)
        MapDirection.EAST -> Vector2d(1, 0)
        MapDirection.SOUTH -> Vector2d(0, -1)
        MapDirection.WEST -> Vector2d(-1, 0)
    }
}
