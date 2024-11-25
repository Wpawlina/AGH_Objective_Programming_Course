package agh.ics.oop.model;

import java.util.HashMap;

import agh.ics.oop.model.util.MapVisualizer;


public class RectangularMap extends  AbstractWorldMap {
    private final int width;
    private final int height;


    public  RectangularMap(int width, int height)
    {
        super();
        this.width=width;
        this.height=height;
        this.boundery=new Boundery(new Vector2d(0,0),new Vector2d(width,height));

    }













    private boolean InTheMap(Vector2d position)
    {
        return position.getX() >= 0 && position.getX() <= this.width && position.getY() >= 0 && position.getY() <= this.height;
    }
    @Override
    public boolean canMoveTo(Vector2d position)
    {
        return InTheMap(position) && super.canMoveTo(position);
    }



    @Override
    public Boundery getCurrentBoundery(){
        return this.boundery;

    }




}
