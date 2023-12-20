package com.example.ultraduker;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    public void start(Stage primaryStage) {
        // Initial Scene with Start Button
        Button startButton = new Button("Start");
        StackPane startRoot = new StackPane(startButton);
        Scene startScene = new Scene(startRoot, 500, 450);



        Text fightText = new Text("A wild enemy appears!");

        Pane dashboard = new Pane();


        Button atackButton =new Button("Atack");
        Button actButton =new Button("Act");
        Button mercyButton =new Button("Mercy");

        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(atackButton, actButton, mercyButton);

        dashboard.getChildren().add(buttonBox);

        HBox.setMargin(atackButton, new Insets(10, 5, 10, 5));
        HBox.setMargin(actButton, new Insets(10, 5, 10, 5));
        HBox.setMargin(mercyButton, new Insets(10, 5, 10, 5));

        dashboard.setLayoutX(50);
        dashboard.setLayoutY(20);

        VBox textBox =  new VBox(10, fightText);
        textBox.setAlignment(Pos.TOP_CENTER);
        Scene fightScene = new Scene(dashboard,500, 450);

        // Setup Start Button Action
        startButton.setOnAction(event -> primaryStage.setScene(fightScene));

        Pane playingField = new Pane();
        playingField.setPrefSize(100, 100);
        playingField.setLayoutX(25);
        playingField.setLayoutY(75);
        playingField.setStyle("-fx-background-color: grey; -fx-border-color: black;");

        // Enemy block
        Rectangle enemyBlock = new Rectangle(30, 30, Color.RED);
        playingField.getChildren().add(enemyBlock);

        // Enemy movement
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(2));
        transition.setToX(70);
        transition.setAutoReverse(true);
        transition.setCycleCount(TranslateTransition.INDEFINITE);
        transition.setNode(enemyBlock);
        transition.play();

        dashboard.getChildren().add(playingField);

        // Configure Stage
        primaryStage.setTitle("Fight");
        primaryStage.setScene(startScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
