package agh.ics.oop.model;


import java.util.LinkedList;

public class Simulation<T,P> {
    private final LinkedList<T> animals;
    private final LinkedList<MoveDirection> moves;

    private final WorldMap<T,P> map;


    public Simulation(LinkedList<T> animals, LinkedList<MoveDirection> moves, WorldMap<T,P> map) {
        this.animals = animals;
        this.moves = moves;
        this.map = map;



    }
    public void run() {
        int n = this.animals.size();
        for (T animal : this.animals) {
            if (!map.place(animal)) {
                throw new IllegalArgumentException("The position is already occupied or out of the map");
            }

        }
        int i=0;
        for (MoveDirection move: this.moves) {
            map.move(animals.get(i), move);
            System.out.println(map);

            i = (i+1)%n;
        }



    }
}
