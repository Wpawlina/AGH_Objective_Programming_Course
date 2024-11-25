package agh.ics.oop.model;




import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import  agh.ics.oop.model.MoveDirection;

import static org.junit.jupiter.api.Assertions.*;

public class OptionParserTest {
    @Test
    public void parseCorrect() {
        String[] atributes = new String[]{"f", "b", "l", "r"};

        LinkedList<MoveDirection> moves = OptionsParser.parse(atributes);

        LinkedList<MoveDirection> expectedResult = new LinkedList<>(Arrays.asList(MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.RIGHT));
        assertEquals(moves, expectedResult);

    }
    @Test
    public void parseIncorrect() {
        String[] atributes = new String[]{"f", "b", "l", "r","wrong"};
        assertThrows(IncorrectPositionException.class, () -> OptionsParser.parse(atributes));
    }
}


