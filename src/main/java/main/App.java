package main;

import main.controllers.Controller;
import main.controllers.UserController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {
    double x,y = 0;

    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/app.fxml")));
        Scene scene = new Scene(root);
        UserController.publicStage = stage;
        Controller.getInstance().loadFile("data.dat");

        root.setOnMousePressed(evt ->{
            x = evt.getSceneX();
            y = evt.getSceneY();
        });

        root.setOnMouseDragged(evt ->{
            stage.setX(evt.getScreenX()- x);
            stage.setY(evt.getScreenY()- y);
        });

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}