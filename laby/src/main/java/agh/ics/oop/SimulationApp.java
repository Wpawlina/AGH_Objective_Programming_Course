package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.presenter.SimulationPresenter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SimulationApp extends Application {

    private WorldMap map;

    public void start(Stage primaryStage) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("simulation.fxml"));
        try {
            BorderPane viewRoot = loader.load();
            SimulationPresenter presenter = loader.getController();
            configureStage(primaryStage, viewRoot);
            primaryStage.show();

            this.map=new GrassField(5);
            map.registerObserver(presenter);
            map.registerObserver((WorldMap map, String message)->
                    {
                        LocalDateTime CurDateTime = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        String formattedDateTime = CurDateTime.format(formatter);
                        System.out.println(formattedDateTime+" "+message);
                    }
            );
            map.registerObserver(new FileMapDisplay());
            presenter.setWorldMap(map);








        }
        catch (IOException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }



    }

    public void  setWorldMap(WorldMap map){
        this.map = map;
    }

    private void configureStage(Stage primaryStage, BorderPane viewRoot) {
        var scene = new Scene(viewRoot);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simulation app");
        primaryStage.minWidthProperty().bind(viewRoot.minWidthProperty());
        primaryStage.minHeightProperty().bind(viewRoot.minHeightProperty());
    }

}
