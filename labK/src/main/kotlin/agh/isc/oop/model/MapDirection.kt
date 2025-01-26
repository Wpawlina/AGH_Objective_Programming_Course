package main.agh.ics.oop.model

import agh.ics.oop.model.Vector2d

enum class MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    fun next(): MapDirection {
        return when (this) {
            NORTH -> EAST
            EAST -> SOUTH
            SOUTH -> WEST
            WEST -> NORTH
        }
    }

    fun previous(): MapDirection {
        return when (this) {
            NORTH -> WEST
            EAST -> NORTH
            SOUTH -> EAST
            WEST -> SOUTH
        }
    }



    override fun toString(): String {
        return when (this) {
            NORTH -> "Północ"
            EAST -> "Wschód"
            SOUTH -> "Południe"
            WEST -> "Zachód"
        }
    }


}