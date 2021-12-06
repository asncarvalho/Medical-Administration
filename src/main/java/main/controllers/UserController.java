/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.models.Doctor;
import main.models.User;
import main.util.Helpers;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;


public class UserController implements Initializable{

    public static Stage publicStage;
    
    @FXML
    private Button btnMakeLogin;
    
    @FXML
    private Button btnSignIn;
    
    @FXML
    private TextField txtLoginField;

    @FXML
    private TextField txtNameField, txtCpfField;
    
    @FXML
    private PasswordField txtPasswordField;

    @FXML
    private PasswordField txtPasswordRegister, txtConfPassRegister;

    @FXML
    private Hyperlink addAccountLink;
    
    @FXML
    private MenuButton selectUserType;

    @FXML
    void btnOnClickLogin(ActionEvent event){
        if(event.getSource() == addAccountLink){
            showAsDialog("register");
        }
        if(event.getSource() == btnMakeLogin){
            Optional<?> userAuth = AuthController.getInstance().logIn(txtLoginField.getText(), txtPasswordField.getText());

            userAuth.ifPresent(System.out::println);
        }
    }
    
   @FXML
   void selectUserLevel(ActionEvent event){
       selectUserType.setText(((MenuItem) event.getSource()).getText());
   }

    //Tela de Cadastro ‘login’ ações
    //Fazer estrutura de dados para o controlador
    @FXML
    void btnRegister(ActionEvent event) throws IOException{
        if (event.getSource() == btnSignIn) {
            if (txtNameField.getText().equals("")) {
                Stage alert = Helpers.alertMaker("Insira um nome válido");
                alert.setAlwaysOnTop(true);
                alert.show();
            }else if (txtCpfField.getText().equals("")) {
                Stage alert = Helpers.alertMaker("Insira um CPF válido");
                alert.setAlwaysOnTop(true);
                alert.show();
            }else if (txtPasswordRegister.getText().equals("")) {
                Stage alert = Helpers.alertMaker("Insira uma senha válida");
                alert.setAlwaysOnTop(true);
                alert.show();
            }else if (txtConfPassRegister.getText().equals("")) {
                Stage alert = Helpers.alertMaker("Confirme sua senha");
                alert.setAlwaysOnTop(true);
                alert.show();
            }else if (!txtPasswordRegister.getText().equals(txtConfPassRegister.getText())) {
                Stage alert = Helpers.alertMaker("Senhas não conferem!");
                alert.setAlwaysOnTop(true);
                alert.show();
            }else{
                String name = txtNameField.getText();
                String cpf = txtCpfField.getText();
                String password = txtPasswordRegister.getText();
                Stage current = (Stage)((Node) event.getSource()).getScene().getWindow();
                Stage alert = Helpers.successAlert("Usuário cadastrado com Sucesso!");
                alert.setAlwaysOnTop(true);
                switch (selectUserType.getText()) {
                    case "Medico" -> {
                        Doctor newDoctor = new Doctor(name, cpf, password);
                        Controller.getInstance().getDoctorsList().add(newDoctor);
                        System.out.println(Controller.getInstance().getDoctorsList().size());
                        Controller.getInstance().saveFile("./src/saves/data.dat");
                        alert.show();
                        current.close();
                    }
                    case "Recepcionista" -> {
                        User newUser = new User(name, cpf, password);
                        Controller.getInstance().getUserList().add(newUser);
                        Controller.getInstance().saveFile("./src/saves/data.dat");
                        alert.show();
                        current.close();
                    }
                    default -> {
                        Stage err = Helpers.alertMaker("Selecione ao menos um tipo de usuário");
                        err.setAlwaysOnTop(true);
                        err.show();
                    }
                }
            }
        }
    }
  
            
    private void showAsDialog(String fxml) {
        try {
            System.out.println(fxml+".fxml");
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/"+fxml+".fxml")));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setAlwaysOnTop(true);
            stage.setX(publicStage.getX() +50);
            stage.setY(publicStage.getY() +50);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        
    }

}