package agh.ics.oop.model;



public class Animal {
    private Vector2d position;
    private MapDirection direction;

    public Animal(){
        this.position = new Vector2d(2,2);
        this.direction = MapDirection.NORTH;
    }

    public  Animal(Vector2d initialPosition){

        if(!inTheMap(initialPosition))
        {
            throw new IllegalArgumentException("Animal position is out of the map");
        }
        this.position = initialPosition;
        this.direction = MapDirection.NORTH;
    }

    @Override
    public String toString() {

        return switch (this.direction)
        {
            case NORTH -> "^";
            case EAST -> ">";
            case SOUTH -> "v";
            case WEST -> "<";
        };


    }
    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }
    public void move(MoveDirection direction, MoveValidator validator)
    {
        switch (direction)
        {
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD -> {
                Vector2d newPosition = this.position.add(this.direction.toUnitVector());
                if (validator.canMoveTo(newPosition))
                {
                    this.position = newPosition;
                }
            }
            case BACKWARD -> {
                Vector2d newPosition = this.position.subtract(this.direction.toUnitVector());

                if (validator.canMoveTo(newPosition))
                {
                    this.position = newPosition;
                }
            }
        }
    }

    public Vector2d getPosition() {
        return this.position;
    }

    public MapDirection getDirection() {
        return this.direction;
    }






    private boolean inTheMap(Vector2d position)
    {
        return position.getX() >= 0 && position.getX() <= 4 && position.getY() >= 0 && position.getY() <= 4;
    }
  
}


