package com.example.ejercicio1di;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private static final String USER = "Carlos";
    private static final String PASSWORD = "123456";


    @FXML
    private CheckBox cbSesion;
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Label info;


    @FXML
    protected void onHelloButtonClick() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void cancel(ActionEvent actionEvent) {
        System.exit(0);
    }

    @FXML
    public void login(ActionEvent actionEvent) {
        //asignación condicional, según una cosa asigno una u otra dependiendo de una expresión
        String texto = (cbSesion.isSelected()) ? "(recordar sesión)":"(no recordar sesión)";

        if (txtUsuario.getText().equals(USER) && txtPassword.getText().equals(PASSWORD)){
            info.setText("Login correcto "+texto);
            info.setStyle("-fx-background-color: green; -fx-text-fill:white;");

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Login");
            alerta.setHeaderText("Éxito");
            alerta.setContentText("Bienvenido "+txtUsuario.getText());
            alerta.showAndWait();


            HelloApplication.loadFXML("main-view.fxml","Principal");




        }else{
            info.setText("Login incorrecto "+texto);
            info.setStyle("-fx-background-color: red; -fx-text-fill:white;");
        }
    }
}