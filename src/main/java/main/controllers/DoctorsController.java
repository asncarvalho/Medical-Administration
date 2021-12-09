package main.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.models.Doctor;
import java.net.URL;
import java.util.ResourceBundle;

public class DoctorsController<T> implements Initializable {

    private T entity;

    @FXML private TextField txtName, txtCpf;

    @FXML private PasswordField txtPassword, txtConfPass;

    @FXML private Button btnEdit;

    /**
     * esse método aceita uma entidade para iniciar a view
     * @param selectedEntity entidade a ser selecionada;
     */
    public void initData(T selectedEntity){
        entity = selectedEntity;
        if(entity instanceof Doctor doctor){
            txtName.setText(doctor.getName());
            txtCpf.setText(doctor.getCpf());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }
}
