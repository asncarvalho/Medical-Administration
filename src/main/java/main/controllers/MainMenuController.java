package main.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.models.Doctor;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    public static Stage publicStage;

    @FXML
    private Button managePatients, manageDoctors, manageSchedule, manageResidencies, selfservicePatients, historyPatients;

    @FXML
    private BorderPane mainPane;

    @FXML
    private TableColumn<Doctor,String> colName, colCPF, colResidencies, colActions;

    @FXML
    private TableView<Doctor> tblMain;


    @FXML
    void btnMngDoctors(ActionEvent event){
        Pane view = getPane("manageDoctors");
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
