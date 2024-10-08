package com.example.ejercicio1di;

import com.example.ejercicio1di.models.User;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MainViewController implements Initializable{
    @FXML
    private ChoiceBox<User> choice;
    @FXML
    private Button btn;
    @FXML
    private ListView<User> lista;
    @FXML
    private DatePicker fecha;
    @FXML
    private Spinner spinner;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*
        //A todos los efectos esto es un arraylist, una lista
        choice.getItems().add("Hola");
        choice.getItems().add("Adios");
        //Por defecto le da el primer valor
        choice.setValue(choice.getItems().get(0));
         */


        choice.getItems().add(new User(1L,"Fran","Jajauja"));
        choice.getItems().add(new User(2L,"Jajas","Jereje"));


        //Permite parsear un objeto (En JFX)
        choice.setConverter(new StringConverter<User>() {
            @Override
            public String toString(User user) {
                if (user != null) return user.getFirstName();
                else return "";
            }

            @Override
            public User fromString(String s) {
                return null;
            }
        });

        lista.getItems().add(new User(1L,"Fran","Jajauja"));
        lista.getItems().add(new User(2L,"Jajas","Jereje"));
        lista.getItems().add(new User(3L,"James","Miller"));

        //LAMBDAS
        fecha.valueProperty().addListener((observableValue, localDate, t1) -> {
            var alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(t1.toString());
            alert.showAndWait();
        });

        fecha.valueProperty().addListener(
                (ObservableValue<? extends LocalDate> observableValue, LocalDate date, LocalDate t1) ->{
                    var alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText(t1.toString());
                    alert.showAndWait();
                }
        );
        //----------------------------

        //Poner un Listener a una lista (mejor que hacer un click)
        //Una propiedad es algo inherente al objeto y puede disparar eventos //el usuario hace click en la lista y cambia pero estamos atentos a la lista cuando cambie
        lista.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends User> observableValue, User before, User after) -> {

                    if (after != null) {
                        var alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information");
                        alert.setHeaderText(after.toString());
                        alert.showAndWait();
                    }

                }

        );
    }

    @FXML
    public void volver(ActionEvent actionEvent) {
        HelloApplication.loadFXML("Hello-view.fxml","Login");
    }


    @FXML
    public void mostrar(ActionEvent actionEvent){
        System.out.println(choice.getValue());
        //visualizar listas
        //System.out.println(lista.getSelectionModel().getSelectedItems());
        //Añadir en la lista los choice
        lista.getItems().add(choice.getValue());
    }
}