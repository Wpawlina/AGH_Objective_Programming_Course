package agh.ics.oop.model;




import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import static java.lang.System.exit;

abstract  public class AbstractWorldMap implements WorldMap {
    final protected MapVisualizer mapVisualizer;
    final protected   HashMap<Vector2d,Animal> animals=new HashMap<>();
    final protected ArrayList<MapChangeListener> observers=new ArrayList<>();
    protected Boundery boundery;
    protected UUID mapId;

    public AbstractWorldMap() {

        this.mapVisualizer = new MapVisualizer(this);
        this.mapId=UUID.randomUUID();
    }

    public void place(Animal animal) throws IncorrectPositionException {
        if(this.canMoveTo(animal.getPosition()))
        {
            this.animals.put(animal.getPosition(),animal);


        }
        else
        {
            throw new IncorrectPositionException(animal.getPosition());
        }
        this.notifyObservers("An animal has been placed at "+animal.getPosition().toString());

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
            case RIGHT, LEFT ->{
                animal.move(direction,this);
                this.notifyObservers("An animal has changed direction from "+oldDirection.toString()+" to "+animal.getDirection().toString());

            }
            case FORWARD, BACKWARD -> {
                animal.move(direction, this);
                this.animals.remove(oldPosition);
                try
                {
                    place(animal);
                }
                catch (IncorrectPositionException e)
                {
                    System.out.println(e.getMessage());
                    exit(1);
                }
                this.notifyObservers("An animal has moved from "+oldPosition.toString()+" to "+animal.getPosition().toString());

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
        return new ArrayList<>(this.animals.values());
    }

    abstract public Boundery getCurrentBounds();


    @Override
    public String toString()
    {
        return this.mapVisualizer.draw(this.getCurrentBounds().lowerLeft(),this.getCurrentBounds().upperRight());
    }
    @Override
    public void registerObserver(MapChangeListener observer)
    {
        this.observers.add(observer);
    }

    public  void romoveObserver(MapChangeListener observer)
    {
        this.observers.remove(observer);
    }

    protected void notifyObservers(String message)
    {
        for(MapChangeListener observer:observers)
        {
           observer.mapChanged(this,message);

        }

    }

    @Override
    public  UUID getId(){
        return  this.mapId;
    }

}
