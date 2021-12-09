package main.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.models.MedicalResidency;
import main.util.Helpers;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ResidenciesController implements Initializable {

    @FXML private TextField txtName;

    @FXML private MenuButton associateDoc;

    @FXML private Button btnSaveorEdit, btnDelete, btnAdd;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML void btnStoreOrEdit(ActionEvent evt) throws IOException {
        if(evt.getSource() == btnSaveorEdit){
            if (txtName.getText().equals("")) Helpers.throwNewAlert("Selecione um nome válido");
            else{
                String desc = txtName.getText();
                MedicalResidency medicalResidency = new MedicalResidency(desc);
                Controller.getInstance().getSpecializations().add(medicalResidency);
                Controller.getInstance().saveFile("data.dat");
                System.out.println(Controller.getInstance().getSpecializations().size());
                Helpers.throwSuccessAlert("Usuário cadastrado com Sucesso!");
                Helpers.closeCurrentStage(evt);
            }
        }
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

    public void btnDestroy(ActionEvent event) {
    }
}
