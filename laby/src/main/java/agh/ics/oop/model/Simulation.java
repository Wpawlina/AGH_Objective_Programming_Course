package agh.ics.oop.model;

import agh.ics.oop.MoveDirection;

import java.util.LinkedList;

public class Simulation {
    private final LinkedList<Vector2d> initialAnimalsPositions;
    private final LinkedList<MoveDirection> moves;


    public Simulation(LinkedList<Vector2d> initialAnimalsPositions, LinkedList<MoveDirection> moves) {
        this.initialAnimalsPositions = initialAnimalsPositions;
        this.moves = moves;
    }
    public void run() {
        int n = this.initialAnimalsPositions.size();
        LinkedList<Animal> animals = new LinkedList<>();
        for (int i=0; i<n; i++) {
            animals.add(new Animal(this.initialAnimalsPositions.get(i)));
        }
        int i=0;
        for (MoveDirection move: this.moves) {
            animals.get(i).move(move);
            System.out.println("Zwierze "+i+" "+animals.get(i));
            i = (i+1)%n;
        }



    }
}
