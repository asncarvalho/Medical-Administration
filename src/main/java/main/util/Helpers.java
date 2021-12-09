/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.util;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Arrays;

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

    public static void throwNewAlert(String desc){
        Stage alert = alertMaker(desc);
        alert.setAlwaysOnTop(true);
        alert.show();
    }
    public static void throwSuccessAlert(String desc){
        Stage alert = successAlert(desc);
        alert.setAlwaysOnTop(true);
        alert.show();
    }

    public static void closeCurrentStage(ActionEvent event){
        Stage current = (Stage)((Node) event.getSource()).getScene().getWindow();
        current.close();
    }

    public Pane getPane(String fileName){
        return null;
    }

//    public Arrays linkedListToArray(LinkedList linkedList){
//        Object[] objArray =
//    }
}
