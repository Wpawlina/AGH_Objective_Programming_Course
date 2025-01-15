package agh.ics.oop.model;


import agh.ics.oop.model.MoveDirection;

import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SimulationIntegrationTest {




    @Test
    public void animalMovementOnARectangularMap()
    {
        String[] atributes = new String[]{"f", "f", "r", "l","f","f"};
        LinkedList<MoveDirection> moves = OptionsParser.parse(atributes);
        Animal animal = new Animal(new Vector2d(2,2));
        Animal animal2 = new Animal(new Vector2d(3,3));
        WorldMap map = new RectangularMap(10, 10);

        try {
            map.place(animal);
            map.place(animal2);
        }
        catch (IncorrectPositionException e)
        {
            assert  false;
        }


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
        assertTrue(map.objectAt(new Vector2d(3,3)).isPresent());
        assertEquals(map.objectAt(new Vector2d(3,3)).get(), animal);
        assertEquals(animal2.getPosition(), new Vector2d(2,4));
        assertTrue(map.objectAt(new Vector2d(2,4)).isPresent());
        assertEquals(map.objectAt(new Vector2d(2,4)).get(), animal2);
    }





}
