package agh.ics.oop;


import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.Vector2d;

public class World {
    public static void main(String[] args) {
        /*Vector2d v1=new Vector2d(1,1);
        Vector2d v2=new Vector2d(2,2);
        Vector2d v3=new Vector2d(2,3);
        System.out.println(v1.precedes(v2));
        System.out.println(v1.precedes(v3));
        System.out.println(v3.followes(v1));
        System.out.println(v3.followes(v3));
        v1=new Vector2d(2,1);
        v2=new Vector2d(1,2);
        System.out.println(v1.lowerLeft(v2));
        System.out.println(v2.upperRight(v1));*/


        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        /*
        MapDirection d1=MapDirection.NORTH;
        System.out.println(d1.next());
        d1=MapDirection.EAST;
        System.out.println(d1.next());
        d1=MapDirection.SOUTH;
        System.out.println(d1.next());
        d1=MapDirection.WEST;
        System.out.println(d1.next());

        MapDirection d2=MapDirection.NORTH;
        System.out.println(d2.previous());
        d2=MapDirection.WEST;
        System.out.println(d2.previous());
        d2=MapDirection.SOUTH;
        System.out.println(d2.previous());
        d2=MapDirection.EAST;
        System.out.println(d2.previous());

        MapDirection d3=MapDirection.NORTH;
        System.out.println(d3.toUnitVector());
        d3=MapDirection.SOUTH;
        System.out.println(d3.toUnitVector());
        d3=MapDirection.EAST;
        System.out.println(d3.toUnitVector());
        d3=MapDirection.WEST;
        System.out.println(d3.toUnitVector());
         */










    }
}
