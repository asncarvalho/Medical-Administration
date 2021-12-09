package main.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    public static Stage publicStage;

    @FXML
    private Button managePatients, manageDoctors, manageSchedule, manageResidencies, selfservicePatients, historyPatients, manageRecords;

    @FXML
    private BorderPane mainPane;

    @FXML
    void btnMngDoctors(ActionEvent event){
        Pane view = getPane("manageDoctors");
        mainPane.setCenter(view);
    }

    @FXML
    void btnManageResidencies(ActionEvent event){
        Pane view = getPane("manageResidences");
        mainPane.setCenter(view);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public Pane getPane(String fxml){
        try{
            return FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/"+fxml+".fxml")));
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
