package agh.ics.oop.model;

public class Grass implements WorldElement {
    final private Vector2d position;

    public Grass(Vector2d position) {
        this.position = position;
    }

    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "*";
    }

    @Override
    public String imageFilePath() {
        return "/grass.png";
    }
}


