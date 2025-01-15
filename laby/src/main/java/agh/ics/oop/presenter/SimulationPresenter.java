package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationEngine;
import agh.ics.oop.World;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SimulationPresenter implements MapChangeListener {

    private static final int CELL_WIDTH = 60;
    private static final int CELL_HEIGHT =60;
    @FXML
    private GridPane gridPane;
    @FXML
    private TextField argumentsInput;
    @FXML
    private Button startButton;
    @FXML
    private Label massageLabel;
    @FXML
    private Label infoLabel;

    private final ObjectProperty<Boolean> isRunning= new SimpleObjectProperty<>(false);


    private WorldMap map;



    @FXML
    private  void initialize(){
        this.startButton.disableProperty().bind(this.isRunning);
        this.argumentsInput.disableProperty().bind(this.isRunning);
        this.startButton.setOnAction(event -> onSimulationStartClicked());

    }

    @FXML
    public boolean isRunning(){
        return this.isRunning.get();
    }

    @FXML
    public void setRunning(boolean running){
        this.isRunning.set(running);
    }

    @FXML
    public ObjectProperty<Boolean> isRunningProperty(){
        return this.isRunning;
    }





    public void setWorldMap(WorldMap map){
        this.map = map;
    }

    public void drawMap(){
       this.clearGrid();
       this.drawGrid();
    }

    @Override
    public synchronized void mapChanged(WorldMap map, String message) {
        Platform.runLater(()->{
            this.massageLabel.setText(message);
            this.drawMap();
        });

    }

    @FXML
    public void onSimulationStartClicked(){
        this.setRunning(true);
        String[] args = this.argumentsInput.getText().split(" ");
        System.out.println(Arrays.toString(args));
        LinkedList<MoveDirection> directions= OptionsParser.parse(args);
        LinkedList<Vector2d> positions =new  LinkedList<Vector2d>(Arrays.asList(new Vector2d(2,2), new Vector2d(5,6)));
        Simulation simulation = new Simulation(positions,directions,this.map);
        ArrayList<Simulation> simulations = new ArrayList<>();
        simulations.add(simulation);
        SimulationEngine simulationEngine = new SimulationEngine(simulations);
        try{
            simulationEngine.runAsync();
        }
        catch (InterruptedException e)
        {
            System.out.println(e.getMessage());
        }


    }
    @FXML
    private void clearGrid() {
        this.gridPane.getChildren().retainAll(this.gridPane.getChildren().getFirst()); // hack to retain visible grid lines
        this.gridPane.getColumnConstraints().clear();
        this.gridPane.getRowConstraints().clear();
    }

    @FXML
    private void drawGrid(){
        Boundery boundery = this.map.getCurrentBounds();
        for(int i=boundery.lowerLeft().getX(); i<=boundery.upperRight().getX(); i++){
            this.gridPane.getColumnConstraints().add(new ColumnConstraints(CELL_WIDTH));
        }
        for(int i=boundery.lowerLeft().getY(); i<=boundery.upperRight().getY(); i++){
            this.gridPane.getRowConstraints().add(new RowConstraints(CELL_HEIGHT));
        }
        this.gridPane.getColumnConstraints().add(new ColumnConstraints(CELL_WIDTH));
        this.gridPane.getRowConstraints().add(new RowConstraints(CELL_HEIGHT));

        GridPane.setHalignment(this.gridPane, HPos.CENTER);
        this.drawAxis(boundery);

    }

    @FXML
    private void drawAxis(Boundery boundery){
        int n=boundery.upperRight().getX()-boundery.lowerLeft().getX()+1;

        for(int i=1; i<=n; i++){
            Label label = new Label(String.valueOf(i+boundery.lowerLeft().getX()-1));
            label.setAlignment(Pos.CENTER);
            label.setMinHeight(CELL_HEIGHT);
            label.setMinWidth(CELL_WIDTH);
            this.gridPane.add(label, i, 0);
        }
        n=boundery.upperRight().getY()-boundery.lowerLeft().getY()+1;
        for(int i=1; i<=n; i++){
            Label label = new Label(String.valueOf(boundery.upperRight().getY()-i+1));
            label.setMinHeight(CELL_HEIGHT);
            label.setMinWidth(CELL_WIDTH);
            label.setAlignment(Pos.CENTER);
            this.gridPane.add(label, 0, i);
        }
        Label label = new Label("Y/X");
        label.setAlignment(Pos.CENTER);
        label.setMinHeight(CELL_HEIGHT);
        label.setMinWidth(CELL_WIDTH);
        this.gridPane.add(label, 0, 0);
        this.drawElements();

    }

    @FXML
    private  void drawElements(){
       ArrayList<WorldElement> elements = (ArrayList<WorldElement>) this.map.getElements();
        for (WorldElement element : elements) {
            this.drawElement(element,this.map.getCurrentBounds());
        }
    }

    @FXML
    private void drawElement(WorldElement element,Boundery boundery){
        VBox vbox = new WorldElementBox(element.imageFilePath(),element.getPosition().toString()).getVBox();
        this.gridPane.add(vbox, element.getPosition().getX() - boundery.lowerLeft().getX()+1, boundery.upperRight().getY() - element.getPosition().getY()+1);
    }



}
