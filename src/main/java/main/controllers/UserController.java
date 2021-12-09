package main.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
            userAuth.ifPresentOrElse((value)
                    -> {
                        showAsDialog("main");
                        Helpers.closeCurrentStage(event);
            }, ()
                    -> Helpers.throwNewAlert("Usuário não encontrado!"));
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
                Helpers.throwNewAlert("Insira um nome válido");
            }else if (txtCpfField.getText().equals("")) {
                Helpers.throwNewAlert("Insira um CPF válido");
            }else if (txtPasswordRegister.getText().equals("")) {
                Helpers.throwNewAlert("Insira uma senha válida");
            }else if (txtConfPassRegister.getText().equals("")) {
                Helpers.throwNewAlert("Confirme sua senha");
            }else if (!txtPasswordRegister.getText().equals(txtConfPassRegister.getText())) {
                Helpers.throwNewAlert("Senhas não conferem!");
            }else{
                String name = txtNameField.getText();
                String cpf = txtCpfField.getText();
                String password = txtPasswordRegister.getText();
                switch (selectUserType.getText()) {
                    case "Medico" -> {
                        Doctor newDoctor = new Doctor(name, cpf, password);
                        Controller.getInstance().getDoctorsList().add(newDoctor);
                        Controller.getInstance().saveFile("data.dat");
                        Helpers.throwSuccessAlert("Usuário cadastrado com Sucesso!");
                        Helpers.closeCurrentStage(event);
                    }
                    case "Recepcionista" -> {
                        User newUser = new User(name, cpf, password);
                        Controller.getInstance().getUserList().add(newUser);
                        Controller.getInstance().saveFile("data.dat");
                        Helpers.throwSuccessAlert("Usuário cadastrado com Sucesso!");
                        Helpers.closeCurrentStage(event);
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