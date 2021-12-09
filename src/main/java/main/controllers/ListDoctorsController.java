package main.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import main.models.Doctor;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListDoctorsController implements Initializable {

    @FXML
    private TableColumn<Doctor,String> colName,colCPF,field1stResidency,field2ndResidency;

    @FXML
    private TableColumn<Doctor, Void>  colActions;

    ObservableList<Doctor> doctorsData = FXCollections.observableArrayList(Controller.getInstance().getDoctorsList().toArray());

    @FXML
    private TableView<Doctor> tblMain;

    private void edit(Doctor doctor, ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/editDoctors.fxml"));
        Parent tableParent = loader.load();
        DoctorsController<Doctor> doctorsController = loader.getController();
        doctorsController.initData(doctor);
        Scene scene = new Scene(tableParent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Callback<TableColumn<Doctor,Void> , TableCell<Doctor, Void>>  cellFactory = new Callback<>() {
            @Override
            public TableCell<Doctor, Void> call(TableColumn<Doctor, Void> doctorVoidTableColumn) {
                return new TableCell<>() {
                    private final Button btn = new Button("Editar/Remover");

                    {
                        btn.setOnAction((ActionEvent evt) -> {
                            Doctor doctor = getTableView().getItems().get(getIndex());
//                            System.out.println("Selected data" + doctor);
                            try {
                                edit(doctor, evt);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) setGraphic(null);
                        else {
                            setGraphic(btn);
                        }
                    }
                };
            }
        };


        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        field1stResidency.setCellValueFactory(new PropertyValueFactory<>("primarySpecialization"));
        field2ndResidency.setCellValueFactory(new PropertyValueFactory<>("secondarySpecialization"));
        colActions.setCellFactory(cellFactory);

        tblMain.setItems(doctorsData);
    }

}
