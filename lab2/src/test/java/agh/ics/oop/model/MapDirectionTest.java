package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapDirectionTest {


    @Test
    public void next() {
        MapDirection initialDirection = MapDirection.NORTH;
        MapDirection nextDirection = initialDirection.next();
        assertEquals(MapDirection.EAST, nextDirection);

        initialDirection = MapDirection.EAST;
        nextDirection = initialDirection.next();
        assertEquals(MapDirection.SOUTH, nextDirection);


        initialDirection = MapDirection.SOUTH;
        nextDirection = initialDirection.next();
        assertEquals(MapDirection.WEST, nextDirection);

        initialDirection = MapDirection.WEST;
        nextDirection = initialDirection.next();
        assertEquals(MapDirection.NORTH, nextDirection);

    }


    @Test
    public void previous() {
        MapDirection initialDirection = MapDirection.NORTH;
        MapDirection nextDirection = initialDirection.previous();
        assertEquals(MapDirection.WEST, nextDirection);

        initialDirection = MapDirection.WEST;
        nextDirection = initialDirection.previous();
        assertEquals(MapDirection.SOUTH, nextDirection);

        initialDirection = MapDirection.SOUTH;
        nextDirection = initialDirection.previous();
        assertEquals(MapDirection.EAST, nextDirection);

        initialDirection = MapDirection.EAST;
        nextDirection = initialDirection.previous();
        assertEquals(MapDirection.NORTH, nextDirection);
    }

    @Test
    public void toUnitVector() {
        MapDirection initialDirection = MapDirection.NORTH;
        Vector2d unitVector = initialDirection.toUnitVector();
        assertTrue((new Vector2d(0, 1)).equals(unitVector));

        initialDirection = MapDirection.EAST;
        unitVector = initialDirection.toUnitVector();
        assertTrue((new Vector2d(1, 0)).equals(unitVector));

        initialDirection = MapDirection.SOUTH;
        unitVector = initialDirection.toUnitVector();
        assertTrue((new Vector2d(0, -1)).equals(unitVector));

        initialDirection = MapDirection.WEST;
        unitVector = initialDirection.toUnitVector();
        assertTrue((new Vector2d(-1, 0)).equals(unitVector));
    }

    @Test
    public void toStringDirection()
    {
        MapDirection initialDirection = MapDirection.NORTH;
        assertEquals("Północ", initialDirection.toString());

        initialDirection = MapDirection.EAST;
        assertEquals("Wschód", initialDirection.toString());

        initialDirection = MapDirection.SOUTH;
        assertEquals("Południe", initialDirection.toString());

        initialDirection = MapDirection.WEST;
        assertEquals("Zachód", initialDirection.toString());

    }






}
