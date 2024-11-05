package agh.ics.oop.model;

import java.util.HashMap;

public class TextMap implements  WorldNumberPositionMap<String,Integer> {
    private final int width;
    private final HashMap<Integer,String> words=new HashMap<>();

    public TextMap(int width)
    {
        this.width=width;
    }

    @Override
    public boolean place(String object)
    {

        int position = 0;
        while (words.containsKey(position)) {
            position++;
        }
        if(position>=this.width) return false;
        words.put(position,object);
        return true;

    }

    @Override
    public void move(String object, MoveDirection direction) {
        if(words.containsValue(object)) {
            int curPosition = 0;
            for (Integer key : words.keySet()) {
                if (words.get(key).equals(object)) {
                    curPosition = key;
                    break;
                }
            }
            switch (direction){
                case RIGHT,FORWARD -> {
                    int newPosition = curPosition + 1;
                    if(canMoveTo(newPosition)){
                        words.remove(curPosition);
                        if(words.containsKey(newPosition)){
                            words.put(curPosition,words.get(newPosition));
                        }
                        words.put(newPosition,object);

                    }
                }
                case LEFT,BACKWARD -> {
                    int newPosition = curPosition - 1;
                    if(canMoveTo(newPosition)){
                        words.remove(curPosition);
                        if(words.containsKey(newPosition)){
                            words.put(curPosition,words.get(newPosition));
                        }
                        words.put(newPosition,object);

                    }
                }


            }


        }
    }

    @Override
    public boolean isOccupied(Integer position)
    {
        return this.words.containsKey(position);
    }
    @Override
    public String objectAt(Integer position)
    {
        return this.words.get(position);
    }
    @Override
    public  boolean canMoveTo(Integer position)
    {
        return position>=0 && position<this.width;
    }

    @Override
    public String toString()
    {
        String result="[ ";
        for (int i=0;i<this.width;i++)
            {
                if (words.containsKey(i)) {
                    result += words.get(i) + ", ";
                } else {
                    result += ", ";
                }
            }
            result += "]";
            return result;

    }





}
