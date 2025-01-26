package agh.ics.oop

import agh.ics.oop.model.Animal
import agh.ics.oop.model.BouncyMap
import agh.ics.oop.model.MoveDirection
import agh.ics.oop.model.Vector2d
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import main.agh.ics.oop.model.MapDirection
import java.lang.IllegalArgumentException

class BouncyMapTest : ShouldSpec({
    should("place animal at the given position when it is free and inside the map") {
        val map = BouncyMap(10, 10)
        val animal = Animal( )
        map.place(animal)
        map.objectAt(Vector2d(2, 2)) shouldBe animal


    }

    should("not place animal at the given position when it is outside the map") {
        val map = BouncyMap(10, 10)
        val animal = Animal(Vector2d(20,20) )
        shouldThrow<IllegalArgumentException> { map.place(animal) }
    }
    should(" not place animal at the given position when it is occupied and there is free space") {
        val map = BouncyMap(10, 10)
        val animal = Animal(Vector2d(2, 2))
        val animal2 = Animal(Vector2d(2, 2))
        map.place(animal)
        map.place(animal2)
        map.objectAt(Vector2d(2, 2)) shouldBe animal
    }
    should("not place animal at the given position when it is occupied and there is no free space") {
        val map = BouncyMap(1, 1)
        val animal = Animal(Vector2d(0, 0))
        val animal2 = Animal(Vector2d(2, 2))
        map.place(animal)
        shouldThrow<IllegalArgumentException> { map.place(animal2) }
        map.objectAt(Vector2d(0, 0)) shouldBe animal
    }

    should("allow movement to the given position when it is inside the map") {
        val map = BouncyMap(10, 10)
        map.canMoveTo(Vector2d(2, 2)) shouldBe true
    }

    should("not allow movement to the given position when it is outside the map") {
        val map = BouncyMap(10, 10)
        map.canMoveTo(Vector2d(20, 20)) shouldBe false
    }

    should("return object at the given position") {
        val map = BouncyMap(10, 10)
        val animal = Animal(Vector2d(2, 2))
        map.place(animal)
        map.objectAt(Vector2d(2, 2)) shouldBe animal
    }

    should("return null when there is no object at the given position") {
        val map = BouncyMap(10, 10)
        map.objectAt(Vector2d(2, 2)) shouldBe null
    }

    should("move animal in the given direction when it is possible")
    {
        val map = BouncyMap(10, 10)
        val animal = Animal(Vector2d(2, 2),MapDirection.NORTH)
        map.place(animal)
        map.move(animal,MoveDirection.LEFT)
        map.objectAt(Vector2d(2, 2)) shouldBe animal
        animal.direction shouldBe MapDirection.WEST
        map.move(animal,MoveDirection.FORWARD)
        println(animal)
        map.objectAt(Vector2d(1, 2)) shouldBe animal
        map.move(animal,MoveDirection.RIGHT)
        map.objectAt(Vector2d(1, 2)) shouldBe animal
        animal.direction shouldBe MapDirection.NORTH
        map.move(animal,MoveDirection.BACKWARD)
        map.objectAt(Vector2d(1, 1)) shouldBe animal

    }





})

