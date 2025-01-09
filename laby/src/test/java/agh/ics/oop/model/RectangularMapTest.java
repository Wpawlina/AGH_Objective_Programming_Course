package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {

    @Test
    void  animalCorrectlyPlaced(){
        RectangularMap map = new RectangularMap(4, 4);
        Vector2d position = new Vector2d(2, 2);
        Animal animal = new Animal(position);
        try {
            map.place(animal);
        }
        catch (IncorrectPositionException e) {
            assert false;
        }

        assert(map.isOccupied(position));
    }


    @Test
    void  animalIncorrectlyPlacedOutOfTheMap(){
        RectangularMap map = new RectangularMap(4, 4);
        Vector2d position = new Vector2d(5, 5);
        Animal animal = new Animal(position);
        assertThrows(IncorrectPositionException.class, () -> map.place(animal));
    }

    @Test
    void animalIncorrectlyPlacedOnAnotherAnimal(){
        RectangularMap map = new RectangularMap(4, 4);
        Vector2d position = new Vector2d(2, 2);
        Animal animal = new Animal(position);
        try {
            map.place(animal);
        }
        catch (IncorrectPositionException e) {
            assert false;
        }

        Animal anotherAnimal = new Animal(position);
        assertThrows(IncorrectPositionException.class, () -> map.place(anotherAnimal));
    }

    @Test
    void objectAt(){
        RectangularMap map = new RectangularMap(4, 4);
        Vector2d position = new Vector2d(2, 2);
        Animal animal = new Animal(position);
        try {
            map.place(animal);
        }
        catch (IncorrectPositionException e) {
            assert false;
        }
        assertTrue(map.objectAt(position).isPresent());
        assertEquals(map.objectAt(position).get(), animal);
    }

    @Test
    void move(){
        RectangularMap map = new RectangularMap(4, 4);
        Vector2d position = new Vector2d(2, 2);
        Animal animal = new Animal(position);
        try {
            map.place(animal);
        }
        catch (IncorrectPositionException e) {
            assert false;
        }

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
        try {
            map.place(animal);
        }
        catch (IncorrectPositionException e) {
            assert false;
        }

        List<WorldElement> elements=map.getElements();
        assertEquals(animal, elements.getFirst());
        assertEquals(1, elements.size());
    }

    @Test
    void getOrderedAnimals()
    {
        RectangularMap map = new RectangularMap(10,10);
        ArrayList<Animal> animals = new ArrayList<>();
         for(int i = 1; i < 10; i++)
        {
            Animal animal = new Animal(new Vector2d(i,i));
            try {
                map.place(animal);
                animals.add(animal);
            }
            catch (IncorrectPositionException e) {
                assert false;
            }
        }

        ArrayList<Animal> orderedAnimals = map.getOrderedAnimals();
        assertEquals(animals, orderedAnimals);




    }



}
