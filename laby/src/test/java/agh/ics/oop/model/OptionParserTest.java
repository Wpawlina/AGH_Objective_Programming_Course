package agh.ics.oop.model;

import agh.ics.oop.MoveDirection;
import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class OptionParserTest {
    @Test
    public void parse()
    {
        String[] atributes= new String[]{"f","b","l","r"};

        MoveDirection[] moves= OptionsParser.parse(atributes);

        MoveDirection[] expectedResult=new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.LEFT,MoveDirection.RIGHT};
        assertTrue(Arrays.equals(expectedResult,moves));
    }






}