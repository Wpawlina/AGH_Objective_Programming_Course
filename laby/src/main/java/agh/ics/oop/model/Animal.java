package agh.ics.oop.model;

import agh.ics.oop.MoveDirection;

public class Animal {
    private Vector2d position;
    private MapDirection direction;

    public Animal(){
        this.position = new Vector2d(2,2);
        this.direction = MapDirection.NORTH;
    }

    public  Animal(Vector2d initialPosition){
        if (initialPosition.getX() < 0 || initialPosition.getX() > 4 || initialPosition.getY() < 0 || initialPosition.getY() > 4)
        {
            throw new IllegalArgumentException("Animal position is out of the map");
        }
        this.position = initialPosition;
        this.direction = MapDirection.NORTH;
    }

    @Override
    public String toString() {
        return "position: " + position + ", direction: " + direction;
    }
    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }
    public void move(MoveDirection direction)
    {
        switch (direction)
        {
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD -> {
                Vector2d newPosition = this.position.add(this.direction.toUnitVector());
                if (newPosition.getX() >= 0 && newPosition.getX() <= 4 && newPosition.getY() >= 0 && newPosition.getY() <= 4)
                {
                    this.position = newPosition;
                }
            }
            case BACKWARD -> {
                Vector2d newPosition = this.position.subtract(this.direction.toUnitVector());
                if (newPosition.getX() >= 0 && newPosition.getX() <= 4 && newPosition.getY() >= 0 && newPosition.getY() <= 4)
                {
                    this.position = newPosition;
                }
            }
        }
    }

}
