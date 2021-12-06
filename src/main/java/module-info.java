module pbl3medicaladmin {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires lombok;

    opens main to javafx.fxml;
    opens main.controllers to javafx.fxml;
    exports main;
    exports main.util;
    exports main.models;
    exports main.controllers;
}