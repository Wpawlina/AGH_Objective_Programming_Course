package agh.ics.oop.model.util;

import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.Iterator;

public class RandomWithoutRepeatingIterator implements Iterator<Vector2d> {
    final private ArrayList<Vector2d> positions=new ArrayList<>();

    public RandomWithoutRepeatingIterator(int number ){

       for (int i = 0; i <=Math.floor(Math.sqrt(number*10)) ; i++) {
            for (int j = 0; j <=Math.floor(Math.sqrt(number*10)) ; j++) {
                this.positions.add(new Vector2d(i,j));
            }

        }
    }

    @Override
    public boolean hasNext(){
        return !this.positions.isEmpty();
    }
    @Override public Vector2d next(){
        int index = (int) Math.floor(Math.random()*this.positions.size());
        Vector2d result = this.positions.get(index);
        this.positions.remove(index);
        return result;
    }

}
