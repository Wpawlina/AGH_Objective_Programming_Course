package agh.ics.oop.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileMapDisplay implements  MapChangeListener{

    @Override
    public  void mapChanged(WorldMap map, String message){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("map"+map.getId()+".txt", true))) {
            writer.write("=====================================");
            writer.newLine();
            writer.write("Map id: "+map.getId());
            writer.newLine();
            writer.write(message);
            writer.newLine();
            writer.write(map.toString());
            writer.newLine();
            writer.write("=====================================");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
