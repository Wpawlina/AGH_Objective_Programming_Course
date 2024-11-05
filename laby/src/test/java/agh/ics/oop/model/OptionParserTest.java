package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OptionParserTest {
    @Test
    public void parse() {
        String[] atributes = new String[]{"f", "b", "l", "r"};

        LinkedList<MoveDirection> moves = OptionsParser.parse(atributes);

        LinkedList<MoveDirection> expectedResult = new LinkedList<>(Arrays.asList(MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.RIGHT));
        assertEquals(moves, expectedResult);

    }
}


