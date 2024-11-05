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

    public enum MapDirection {
        NORTH,
        EAST,
        SOUTH,
        WEST;

        public String toString(){
            return switch (this)
            {
                case NORTH -> "Północ";
                case EAST -> "Wschód";
                case SOUTH-> "Południe";
                case WEST->"Zachód";
            };
        }
        public MapDirection next(){
            return  switch (this){
                case EAST -> SOUTH;
                case SOUTH -> WEST;
                case WEST-> NORTH;
                case NORTH -> EAST;
            };
        }
        public MapDirection previous()
        {
            return switch (this){
                case EAST -> NORTH;
                case NORTH -> WEST;
                case WEST -> SOUTH;
                case SOUTH -> EAST;
            };
        }
        public  Vector2d toUnitVector(){
            return  switch (this){
                case NORTH -> new Vector2d(0,1);
                case WEST -> new Vector2d(-1,0);
                case EAST -> new Vector2d(1,0);
                case SOUTH -> new Vector2d(0,-1);

            };
        }
    }
}
