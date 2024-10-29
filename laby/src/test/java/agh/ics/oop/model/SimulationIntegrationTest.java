package agh.ics.oop.model;

import agh.ics.oop.MoveDirection;
import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SimulationIntegrationTest {


    @Test
    public void parsingArguments()
    {
        String[] atributes = new String[]{"f","f","f","r","l","f","w","s","b"};
        LinkedList<MoveDirection> moves = OptionsParser.parse(atributes);
        LinkedList<MoveDirection> expected = new LinkedList<>();
        expected.add(MoveDirection.FORWARD);
        expected.add(MoveDirection.FORWARD);
        expected.add(MoveDirection.FORWARD);
        expected.add(MoveDirection.RIGHT);
        expected.add(MoveDirection.LEFT);
        expected.add(MoveDirection.FORWARD);
        expected.add(MoveDirection.BACKWARD);
        assertEquals(moves, expected);
    }

    @Test
    public void animalOrientation()
    {
        Animal animal = new Animal();
        String[] atributes = new String[]{"r", "l", "l", "l", "r"};
        LinkedList<MoveDirection> moves = OptionsParser.parse(atributes);
        for (MoveDirection move: moves) {
            animal.move(move);
        }
        assertEquals(animal.toString(), "position: (2,2), direction: Zachód");
    }

    @Test
    public void animalPosition()
    {
        Animal animal = new Animal();
        String[] atributes = new String[]{"f","l","b","l","f","r","b"};
        LinkedList<MoveDirection> moves = OptionsParser.parse(atributes);
        for (MoveDirection move: moves) {
            animal.move(move);
        }
        assertEquals(animal.toString(), "position: (4,2), direction: Zachód");
    }

    @Test
    public void mapLimit()
    {
        Animal animal = new Animal();
        String[] atributes = new String[]{"f","f","f","r","f","f","f"};
        LinkedList<MoveDirection> moves = OptionsParser.parse(atributes);
        for (MoveDirection move : moves) {
            animal.move(move);
        }
        assertEquals(animal.toString(), "position: (4,4), direction: Wschód");
    }



}
