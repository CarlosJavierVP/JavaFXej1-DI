package com.example.ejercicio1di;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable{


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void volver(ActionEvent actionEvent) {
        HelloApplication.loadFXML("Hello-view.fxml","Login");
    }
}