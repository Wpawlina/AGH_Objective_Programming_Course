package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulationEngine {
    final ArrayList<Simulation> simulations;
    private ExecutorService executor=Executors.newFixedThreadPool(4);
    private ArrayList<Thread> threads = new ArrayList<>();


    public  SimulationEngine(ArrayList<Simulation> simulations) {
        this.simulations = simulations;
    }

    public void runSync()
    {
        for (Simulation simulation : simulations) {
            simulation.run();

        }
    }

    public  void runAsyncInThreadPool() throws InterruptedException
    {

        for (Simulation simulation : simulations) {
            executor.execute(simulation);
        }
        awaitSimulationsEnd();


    }

    public void runAsync() throws InterruptedException
    {

        for (Simulation simulation : simulations) {
            this.threads.add(new Thread(simulation));
        }
        for (Thread thread : threads) {
            thread.start();
        }


    }

    private void awaitSimulationsEnd() throws InterruptedException
    {
        for (Thread thread : this.threads) {
            thread.join();
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);


    }





}
