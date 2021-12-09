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
import main.models.MedicalResidency;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ListResidenciesController implements Initializable {

    @FXML public Button btnAdd;

    @FXML private TableView<MedicalResidency> tblMain;

    @FXML private TableColumn<MedicalResidency,String> colName;

    @FXML private TableColumn<MedicalResidency,Void>  colActions;

    ObservableList<MedicalResidency> residencyObservableList = FXCollections.observableList(Controller.getInstance().getSpecializations().toArray());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Callback<TableColumn<MedicalResidency,Void> , TableCell<MedicalResidency, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<MedicalResidency, Void> call(TableColumn<MedicalResidency, Void> doctorVoidTableColumn) {
                return new TableCell<>() {
                    private final Button btn = new Button("Editar/Remover");

                    {
                        btn.setOnAction((ActionEvent evt) -> {
                            MedicalResidency residency = getTableView().getItems().get(getIndex());
                            System.out.println("Selected data" + residency);
//                            try {
//                                edit(doctor, evt);
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
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

        colName.setCellValueFactory(new PropertyValueFactory<>("description"));
        colActions.setCellFactory(cellFactory);

        tblMain.setItems(residencyObservableList);
    }

    @FXML void addResidency(ActionEvent evt){
        if(evt.getSource() == btnAdd){
            showAsDialog("editResidency");
        }
    }

    private void showAsDialog(String fxml) {
        try {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/"+fxml+".fxml")));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setAlwaysOnTop(true);

            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
