package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

abstract  public class AbstractWorldMap implements WorldMap {
    final protected MapVisualizer mapVisualizer;
    final protected   HashMap<Vector2d,Animal> animals=new HashMap<>();

    public AbstractWorldMap() {
        this.mapVisualizer = new MapVisualizer(this);
    }

    public boolean place(Animal animal){
        if(this.canMoveTo(animal.getPosition()))
        {
            this.animals.put(animal.getPosition(),animal);
            return true;
        }
        else
        {
            throw new IllegalArgumentException("The position is already occupied or out of the map");
        }

    }


    public void move(Animal animal, MoveDirection direction)
    {
        if(!this.animals.containsKey(animal.getPosition()))
        {
            throw new IllegalArgumentException("The animal is not on the map");
        }
        Vector2d oldPosition=animal.getPosition();
        MapDirection oldDirection=animal.getDirection();
        switch (direction) {
            case RIGHT, LEFT -> animal.move(direction,this);
            case FORWARD, BACKWARD -> {
                animal.move(direction, this);
                this.animals.remove(oldPosition);
                place(animal);
            }
        }
    }

    public WorldElement objectAt(Vector2d position)
    {
        return  this.animals.get(position);
    }

    public boolean canMoveTo(Vector2d position)
    {
        return  !isOccupied(position);
    }


    public boolean isOccupied(Vector2d position)
    {
        return this.animals.containsKey(position);
    }


    public List<WorldElement> getElements()
    {
        List<WorldElement> elements = new ArrayList<>(this.animals.values());
        return elements;
    }

}
