package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;
import agh.ics.oop.model.util.RandomWithoutRepeating;
import agh.ics.oop.model.util.RandomWithoutRepeatingIterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class GrassField  extends  AbstractWorldMap{

    final private  HashMap<Vector2d,Grass> grass=new HashMap<>();


    public GrassField(int grass) {
        super();
        RandomWithoutRepeating randomWithoutRepeating=new RandomWithoutRepeating(10);
        RandomWithoutRepeatingIterator iterator=randomWithoutRepeating.iterator();
        for(int i=0;i<grass;i++)
        {
            if(iterator.hasNext())
            {
                Vector2d position=iterator.next();
                Grass grass1=new Grass(position);
                this.grass.put(position,grass1);
            }
        }
        this.boundery=new Boundery(this.lowerLeft(),this.upperRight());
    }

    @Override
    public boolean isOccupied(Vector2d position)
    {
        return super.isOccupied(position) || this.grass.containsKey(position);
    }




    @Override
    public Optional<WorldElement> objectAt(Vector2d position)
    {
//        return super.objectAt(position)!=null?super.objectAt(position):this.grass.get(position);
        return  Optional.ofNullable(super.objectAt(position).orElse(this.grass.get(position)));

    }

    @Override
    public List<WorldElement> getElements()
    {
//        List<WorldElement> elements=super.getElements();
//        elements.addAll(this.grass.values());
//        return elements;
       return new ArrayList<WorldElement> ( Stream.concat(super.getElements().stream(),this.grass.values().stream()).toList());

    }






    @Override
    public Boundery getCurrentBounds()
    {
        this.boundery=new Boundery(this.lowerLeft(),this.upperRight());
        return this.boundery;
    }







    private Vector2d upperRight()
    {
        int maxX;
        int maxY;
        if(!this.animals.isEmpty())
        {
            maxX=animals.entrySet().iterator().next().getValue().getPosition().getX();
            maxY=animals.entrySet().iterator().next().getValue().getPosition().getY();
        }
        else if(!this.grass.isEmpty())
        {
            maxX=grass.entrySet().iterator().next().getValue().getPosition().getX();
            maxY=grass.entrySet().iterator().next().getValue().getPosition().getY();
        }
        else {
            throw new IllegalArgumentException("The map is empty");
        }



        for (Vector2d vector2d : animals.keySet()) {
            maxX=Math.max(maxX,vector2d.getX());
            maxY=Math.max(maxY,vector2d.getY());
        }
        for (Vector2d vector2d : grass.keySet()) {
            maxX=Math.max(maxX,vector2d.getX());
            maxY=Math.max(maxY,vector2d.getY());
        }
        return new Vector2d(maxX,maxY);

    }
    private Vector2d lowerLeft()
    {
        int minX;
        int minY;
        if(!this.animals.isEmpty())
        {
            minX=animals.entrySet().iterator().next().getValue().getPosition().getX();
            minY=animals.entrySet().iterator().next().getValue().getPosition().getY();
        }
        else if(!this.grass.isEmpty())
        {
            minX=grass.entrySet().iterator().next().getValue().getPosition().getX();
            minY=grass.entrySet().iterator().next().getValue().getPosition().getY();
        }
        else {
            throw new IllegalArgumentException("The map is empty");
        }

        for (Vector2d vector2d : animals.keySet()) {
            minX=Math.min(minX,vector2d.getX());
            minY=Math.min(minY,vector2d.getY());

        }
        for (Vector2d vector2d : grass.keySet()) {
            minX=Math.min(minX,vector2d.getX());
            minY=Math.min(minY,vector2d.getY());
        }
        return  new Vector2d(minX,minY);
    }


}

