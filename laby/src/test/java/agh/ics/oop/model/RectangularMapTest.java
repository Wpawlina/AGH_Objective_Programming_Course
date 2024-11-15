package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {

    @Test
    void  animalCorrectlyPlaced(){
        RectangularMap map = new RectangularMap(4, 4);
        Vector2d position = new Vector2d(2, 2);
        Animal animal = new Animal(position);
        map.place(animal);
        assert(map.isOccupied(position));
    }


    @Test
    void  animalIncorrectlyPlacedOutOfTheMap(){
        RectangularMap map = new RectangularMap(4, 4);
        Vector2d position = new Vector2d(5, 5);
        Animal animal = new Animal(position);
        assertThrows(IllegalArgumentException.class, () -> map.place(animal));
    }

    @Test
    void animalIncorrectlyPlacedOnAnotherAnimal(){
        RectangularMap map = new RectangularMap(4, 4);
        Vector2d position = new Vector2d(2, 2);
        Animal animal = new Animal(position);
        map.place(animal);
        Animal anotherAnimal = new Animal(position);
        assertThrows(IllegalArgumentException.class, () -> map.place(anotherAnimal));
    }

    @Test
    void objectAt(){
        RectangularMap map = new RectangularMap(4, 4);
        Vector2d position = new Vector2d(2, 2);
        Animal animal = new Animal(position);
        map.place(animal);
        assertEquals(animal, map.objectAt(position));
    }

    @Test
    void move(){
        RectangularMap map = new RectangularMap(4, 4);
        Vector2d position = new Vector2d(2, 2);
        Animal animal = new Animal(position);
        map.place(animal);
        map.move(animal, MoveDirection.FORWARD);
        assertEquals(new Vector2d(2, 3), animal.getPosition());
        map.move(animal, MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST, animal.getDirection());
        map.move(animal, MoveDirection.FORWARD);
        assertEquals(new Vector2d(3, 3), animal.getPosition());
        map.move(animal, MoveDirection.BACKWARD);
        assertEquals(new Vector2d(2, 3), animal.getPosition());
        map.move(animal, MoveDirection.LEFT);
        assertEquals(MapDirection.NORTH, animal.getDirection());
    }

    @Test
    void getElements()
    {
        RectangularMap map = new RectangularMap(4, 4);
        Vector2d position = new Vector2d(2, 2);
        Animal animal = new Animal(position);
        map.place(animal);
        List<WorldElement> elements=map.getElements();
        assertEquals(animal, elements.getFirst());
        assertEquals(1, elements.size());
    }



}
