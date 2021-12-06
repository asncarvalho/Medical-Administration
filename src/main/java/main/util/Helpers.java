/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class Helpers {
    //AlertMaker
    public static Stage alertMaker(String desc){
        Alert alert = new Alert(Alert.AlertType.ERROR, desc, ButtonType.OK);
        return (Stage) alert.getDialogPane().getScene().getWindow();
    }
    
    public static Stage successAlert(String desc){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, desc, ButtonType.OK);
        return (Stage) alert.getDialogPane().getScene().getWindow();
    }
}
