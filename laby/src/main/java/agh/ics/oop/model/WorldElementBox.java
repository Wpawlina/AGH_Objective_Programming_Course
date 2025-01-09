package agh.ics.oop.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

import java.util.Objects;

public class WorldElementBox {
    private final VBox vBox;


    public WorldElementBox(String imagePath, String labelText) {

        Image image = new Image(Objects.requireNonNull(getClass().getResource(imagePath)).toExternalForm());


        ImageView imageView = new ImageView(imagePath);


        imageView.setFitWidth(30);
        imageView.setFitHeight(30);


        Label label = new Label(labelText);


        vBox = new VBox(0);
        vBox.getChildren().addAll(imageView, label);


        vBox.setAlignment(Pos.CENTER);
    }


    public VBox getVBox() {
        return vBox;
    }
}
