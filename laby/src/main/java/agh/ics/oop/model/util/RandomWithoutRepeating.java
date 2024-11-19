package agh.ics.oop.model.util;

import agh.ics.oop.model.Vector2d;

public class RandomWithoutRepeating implements Iterable<Vector2d> {
    final private RandomWithoutRepeatingIterator iterator;

    public RandomWithoutRepeating(int number){
        this.iterator = new RandomWithoutRepeatingIterator(number);
    }

    @Override
    public RandomWithoutRepeatingIterator iterator(){
        return this.iterator;
    }


}
