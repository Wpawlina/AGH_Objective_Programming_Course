package agh.ics.oop;


import agh.ics.oop.model.*;
import agh.ics.oop.model.MoveDirection;


import java.util.Arrays;
import java.util.LinkedList;

public class World {
    public static void main(String[] args) {
        Animal animal1 = new Animal();
        System.out.println(animal1);
        Animal animal2 = new Animal(new Vector2d(1,2));
        System.out.println(animal2);

        LinkedList<MoveDirection> directions = OptionsParser.parse(args);
        LinkedList<Animal> animals =new  LinkedList<>(Arrays.asList(animal1, animal2));
        WorldMap<Animal, Vector2d> map = new RectangularMap(10, 5);
        Simulation<Animal,Vector2d> simulation = new Simulation<>(animals, directions, map);

        simulation.run();


        LinkedList<String> words=new LinkedList<>(Arrays.asList("Ala","ma","kota"));
        WorldMap<String,Integer> textMap = new TextMap(5);
        Simulation<String,Integer> textSimulation = new Simulation<>(words, directions, textMap);
        textSimulation.run();











    }
}
