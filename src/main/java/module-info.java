module com.example.ejercicio1di {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejercicio1di to javafx.fxml;
    exports com.example.ejercicio1di;
}