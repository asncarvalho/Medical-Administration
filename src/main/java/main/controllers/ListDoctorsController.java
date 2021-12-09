package main.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.models.Doctor;

import java.net.URL;
import java.util.ResourceBundle;

public class ListDoctorsController implements Initializable {

    @FXML
    private TableColumn<Doctor,String> colName, colCPF, colResidencies, colActions;

    final ObservableList<Doctor> doctorsData = FXCollections.observableArrayList(Controller.getInstance().getDoctorsList().toArray());

    @FXML
    private TableView<Doctor> tblMain;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        
        tblMain.setItems(doctorsData);
    }
}
