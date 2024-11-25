package agh.ics.oop;


import agh.ics.oop.model.*;
import agh.ics.oop.model.MoveDirection;


import java.util.*;

import static java.lang.System.exit;

public class World {
    public static void main(String[] args) {

        LinkedList<MoveDirection> directions= new LinkedList<>();
        try
        {
             directions = OptionsParser.parse(args);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
            exit(1);
        }

        LinkedList<Vector2d> positions =new  LinkedList<Vector2d>(Arrays.asList(new Vector2d(12,12), new Vector2d(15,16)));
        ArrayList<AbstractWorldMap> maps=new ArrayList<>();
        for(int i=0;i<1000;i++)
        {
            maps.add(new RectangularMap(20,20));
        }
        for(int i=0;i<1000;i++)
        {
            maps.add(new GrassField(1));
        }



        ConsoleMapDisplay displayer= new ConsoleMapDisplay();
        for (AbstractWorldMap map : maps) {
            map.registerObserver(displayer);

        }


        ArrayList<Simulation> simulations =new ArrayList<>();
        for (AbstractWorldMap map : maps) {
            simulations.add(new Simulation(positions,directions,map));

        }
        SimulationEngine simulationEngine = new SimulationEngine(simulations);

       // simulationEngine.runSync();
        try{
            //simulationEngine.runAsync();
            simulationEngine.runAsyncInThreadPool();

        }
        catch (InterruptedException e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println("system zakoczył działanie");










    }
}
