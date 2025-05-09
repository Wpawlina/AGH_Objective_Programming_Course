package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {

    @Test
    public void equalsSameVectors() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 =v1;

        assertTrue( v1.equals(v2));
    }
    @Test
    public void equalsDifferentVectorsSameValues() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(1, 2);

        assertTrue( v1.equals(v2));
    }
    @Test
    public void equalsDifferentVectorsDifferentValues() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(2, 1);

        assertFalse( v1.equals(v2));
    }

    @Test
    public void toStringVector() {
        Vector2d v1 = new Vector2d(1, 2);

        assertEquals("(1,2)", v1.toString());
    }

    @Test
    public void precedesTrue() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(2, 3);

        assertTrue(v1.precedes(v2));
    }
    @Test
    public void precedesFalse() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(0, 1);
        assertFalse(v1.precedes(v2));
    }

    @Test
    public void followesTrue() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(2, 3);


        assertTrue(v2.follows(v1));

    }

    @Test
    public void followesFalse() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(0, 1);

        assertFalse(v2.follows(v1));

    }

    @Test
    public void upperRight() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(2, 3);

        assertTrue((new Vector2d(2, 3)).equals(v1.upperRight(v2)));
    }

    @Test
    public void lowerLeft() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(2, 3);

        assertTrue((new Vector2d(1, 2)).equals(v1.lowerLeft(v2)));
    }

    @Test
    public void add()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(2, 3);

        Vector2d result = v1.add(v2);

        assertTrue((new Vector2d(3, 5)).equals(result));
    }

    @Test
    public void subtract()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(2, 3);

        Vector2d result = v1.subtract(v2);

        assertTrue((new Vector2d(-1, -1)).equals(result));
    }

    @Test
    public  void opposite()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d result = v1.opposite();
        assertTrue((new Vector2d(-1, -2)).equals(result));
    }




}