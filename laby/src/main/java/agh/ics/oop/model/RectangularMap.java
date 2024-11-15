package agh.ics.oop.model;

import java.util.HashMap;

import agh.ics.oop.model.util.MapVisualizer;


public class RectangularMap extends  AbstractWorldMap {
    private final int width;
    private final int height;
    private final Vector2d lowerLeft;
    private final Vector2d upperRight;

    public  RectangularMap(int width, int height)
    {
        super();
        this.width=width;
        this.height=height;
        this.lowerLeft=new Vector2d(0,0);
        this.upperRight=new Vector2d(this.width,this.height);

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
    public String toString()
    {
        return this.mapVisualizer.draw(this.lowerLeft, this.upperRight);
    }




}
