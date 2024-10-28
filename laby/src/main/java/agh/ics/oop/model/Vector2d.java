package agh.ics.oop.model;

import java.util.Objects;

public class Vector2d {
    private final int x;
    private final  int y;
    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
    public boolean precedes(Vector2d vector) {
        return this.x <= vector.getX() && this.y <= vector.getY();
    }
    public boolean followes(Vector2d vector) {
        return this.x >= vector.getX() && this.y >= vector.getY();
    }
    public Vector2d add(Vector2d vector) {
        return new Vector2d(x + vector.getX(), y + vector.getY());
    }
    public Vector2d subtract(Vector2d vector) {
        return new Vector2d(x - vector.getX(), y - vector.getY());
    }
    public Vector2d upperRight(Vector2d vector) {
        return new Vector2d( Math.max(x, vector.getX()), Math.max(y, vector.getY()));
    }
    public Vector2d lowerLeft(Vector2d vector) {
        return new Vector2d( Math.min(x, vector.getX()), Math.min(y, vector.getY()));
    }
    public Vector2d opposite() {
        return new Vector2d(-this.x, -this.y);
    }
    public boolean equals(Vector2d vector) {
        if (this==vector) return true;
        if (vector == null) return false;
        return this.x == vector.getX() && this.y == vector.getY();
    }
    public int hashCode() {
        return Objects.hash(this.x,this.y);
    }




}
