package agh.ics.oop;


import agh.ics.oop.model.*;
import agh.ics.oop.model.MoveDirection;


import java.util.Arrays;
import java.util.LinkedList;

import static java.lang.System.exit;

public class World {
    public static void main(String[] args) {
        Animal animal1 = new Animal();

        Animal animal2 = new Animal(new Vector2d(1,2));

        LinkedList<MoveDirection> directions= new LinkedList<>();
        try
        {
             directions = OptionsParser.parse(args);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
            exit(1);
        }

        LinkedList<Vector2d> positions =new  LinkedList<Vector2d>(Arrays.asList(new Vector2d(2,2), new Vector2d(3,4)));
        AbstractWorldMap map = new GrassField(10);
        map.registerObserver(new ConsoleMapDisplay());


        Simulation simulation = new Simulation(positions, directions, map);

        simulation.run();










    }
}
