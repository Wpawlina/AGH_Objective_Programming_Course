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
    public void animalMovement()
    {
        Animal animal = new Animal();
        Animal animal2 = new Animal();
        LinkedList<Animal> animals = new LinkedList<>();
        animals.add(animal);
        animals.add(animal2);
        String[] atributes = new String[]{"f","b","f","b","f","b"};
        LinkedList<MoveDirection> moves = OptionsParser.parse(atributes);
        int i=0;
        for (MoveDirection move: moves) {
            animals.get(i).move(move);
            i=(i+1)%2;

        }
        assertEquals(animal.toString(), "position: (2,4), direction: Północ");
        assertEquals(animal2.toString(),"position: (2,0), direction: Północ");
    }





}
