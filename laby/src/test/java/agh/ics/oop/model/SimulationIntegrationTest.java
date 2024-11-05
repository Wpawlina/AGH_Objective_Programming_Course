package agh.ics.oop.model;


import agh.ics.oop.model.MoveDirection;

import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SimulationIntegrationTest {




    @Test
    public void animalMovementOnAMap()
    {
        String[] atributes = new String[]{"f", "f", "r", "l","f","f"};
        LinkedList<MoveDirection> moves = OptionsParser.parse(atributes);
        Animal animal = new Animal(new Vector2d(2,2));
        Animal animal2 = new Animal(new Vector2d(3,3));
        WorldMap map = new RectangularMap(10, 10);


        map.place(animal);
        map.place(animal2);
        int i=0;
        for (MoveDirection move : moves) {
            if(i==0)
            {
                map.move(animal, move);
                i++;
            }
            else
            {
                map.move(animal2, move);
                i=0;
            }

        }

        assertEquals(animal.getPosition(), new Vector2d(3,3));
        assertEquals(map.objectAt(new Vector2d(3,3)), animal);
        assertEquals(animal2.getPosition(), new Vector2d(2,4));
        assertEquals(map.objectAt(new Vector2d(2,4)), animal2);


    }





}
