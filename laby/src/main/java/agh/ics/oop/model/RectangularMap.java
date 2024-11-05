package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Vector;

import agh.ics.oop.model.util.MapVisualizer;


public class RectangularMap implements WorldMap<Animal, Vector2d> {
    private final HashMap<Vector2d,Animal> animals=new HashMap<>();
    private final int width;
    private final int height;
    private final MapVisualizer mapVisualizer;
    private final Vector2d lowerLeft;
    private final Vector2d upperRight;

    public  RectangularMap(int width, int height)
    {
        this.width=width;
        this.height=height;
        this.mapVisualizer=new MapVisualizer(this);
        this.lowerLeft=new Vector2d(0,0);
        this.upperRight=new Vector2d(this.width,this.height);

    }
    @Override
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


    @Override
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
            case FORWARD -> {
                Vector2d newPosition = animal.getPosition().add(oldDirection.toUnitVector());
                animal.move(direction, this);
                this.animals.remove(oldPosition);
                place(animal);

            }
            case BACKWARD -> {
                Vector2d newPosition = animal.getPosition().subtract(oldDirection.toUnitVector());
                animal.move(direction, this);
                this.animals.remove(oldPosition);
                place(animal);

            }
        }
    }
    @Override
    public boolean isOccupied(Vector2d position)
    {
        return this.animals.containsKey(position);
    }
    @Override
    public Animal objectAt(Vector2d position)
    {
        return  this.animals.get(position);
    }




    private boolean InTheMap(Vector2d position)
    {
        return position.getX() >= 0 && position.getX() <= this.width && position.getY() >= 0 && position.getY() <= this.height;
    }
    @Override
    public boolean canMoveTo(Vector2d position)
    {
        return InTheMap(position) && !isOccupied(position);
    }
    @Override
    public String toString()
    {


        return this.mapVisualizer.draw(this.lowerLeft, this.upperRight);
    }




}
