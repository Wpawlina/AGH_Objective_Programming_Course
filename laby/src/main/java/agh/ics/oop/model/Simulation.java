package agh.ics.oop.model;

import java.util.LinkedList;

public class Simulation {
    private final LinkedList<Vector2d> initialAnimalsPositions;
    private final LinkedList<MoveDirection> moves;
    private final WorldMap map;


    public Simulation(LinkedList<Vector2d> initialAnimalsPositions, LinkedList<MoveDirection> moves, WorldMap map) {
        this.initialAnimalsPositions = initialAnimalsPositions;
        this.moves = moves;
        this.map = map;

    }
    public void run() {
        int n = this.initialAnimalsPositions.size();
        LinkedList<Animal> animals = new LinkedList<>();
        for (int i=0; i<n; i++) {
            Animal animal = new Animal(this.initialAnimalsPositions.get(i));
            if(!map.place(animal)) {
                throw new IllegalArgumentException("The position is already occupied or out of the map");
            }
            animals.add(animal);
        }
        int i=0;
        for (MoveDirection move: this.moves) {
            map.move(animals.get(i), move);
            System.out.println(map);
            i = (i+1)%n;
        }



    }
}
