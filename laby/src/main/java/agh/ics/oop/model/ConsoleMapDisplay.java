package agh.ics.oop.model;


public class ConsoleMapDisplay implements MapChangeListener {
    private  int messageCounter = 0;
    
    @Override
    public synchronized   void mapChanged(WorldMap map, String message) {
            System.out.println(message);

            System.out.println(map.getId());
            System.out.println(map);
            this.messageCounter++;
            System.out.println("Received messages:"+messageCounter+".");

    }
}
