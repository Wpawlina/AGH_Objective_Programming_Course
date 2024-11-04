package agh.ics.oop;


import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.Simulation;
import agh.ics.oop.model.Vector2d;

import java.util.Arrays;
import java.util.LinkedList;

public class World {
    public static void main(String[] args) {
        Animal animal1 = new Animal();
        System.out.println(animal1);
        Animal animal2 = new Animal(new Vector2d(1,2));
        System.out.println(animal2);

        LinkedList<MoveDirection> directions = OptionsParser.parse(args);
        LinkedList<Vector2d> positions =new  LinkedList<Vector2d>(Arrays.asList(new Vector2d(2,2), new Vector2d(3,4)));
        Simulation simulation = new Simulation(positions, directions);
        simulation.run();









    }
}
