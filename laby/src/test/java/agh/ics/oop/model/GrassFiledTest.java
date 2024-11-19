package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GrassFiledTest {
    @Test
    void animalCorrectlyPlaced(){
        GrassField map = new GrassField(4);
        Vector2d position = new Vector2d(10, 10);
        Animal animal = new Animal(position);
        map.place(animal);
        assert(map.isOccupied(position));
    }
    @Test
    void animalIncorrectlyPlacedOnAnotherAnimal(){
        GrassField map = new GrassField(1);
        Vector2d position = new Vector2d(5, 5);
        Animal animal = new Animal(position);
        map.place(animal);
        Animal anotherAnimal = new Animal(position);
        assertThrows(IllegalArgumentException.class, () -> map.place(anotherAnimal));
    }

    @Test
    void animalIncorrectlyPlacedOnGrass(){
        GrassField map = new GrassField(1);

        for(int i=0;i<=Math.sqrt(10);i++)
        {
            for(int j=0;j<=Math.sqrt(10);j++) {

                Vector2d position = new Vector2d(i, j);

                if (map.isOccupied(position)) {
                    Animal animal = new Animal(position);
                    assertThrows(IllegalArgumentException.class, () -> map.place(animal));
                }

            }
        }
    }

    @Test
    void AnimalobjectAt(){
        GrassField map = new GrassField(4);
        Vector2d position = new Vector2d(10, 10);
        Animal animal = new Animal(position);
        map.place(animal);
        assertEquals(animal, map.objectAt(position));
    }


    @Test
    void move(){
        GrassField map = new GrassField(1);
        Vector2d position = new Vector2d(20, 20);
        Animal animal = new Animal(position);
        map.place(animal);
        map.move(animal, MoveDirection.FORWARD);
        assertEquals(new Vector2d(20, 21), animal.getPosition());
        map.move(animal, MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST, animal.getDirection());
        map.move(animal, MoveDirection.FORWARD);
        assertEquals(new Vector2d(21, 21), animal.getPosition());
        map.move(animal, MoveDirection.BACKWARD);
        assertEquals(new Vector2d(20, 21), animal.getPosition());
        map.move(animal, MoveDirection.LEFT);
        assertEquals(MapDirection.NORTH, animal.getDirection());
    }

    @Test
    void getElements()
    {
        GrassField map = new GrassField(4);
        Vector2d position = new Vector2d(10, 10);
        Animal animal = new Animal(position);
        map.place(animal);
        List<WorldElement> elements=map.getElements();
        assertEquals(animal,elements.getFirst()) ;
        assertEquals(5, elements.size());
    }




}
