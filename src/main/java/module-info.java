module com.example.playxo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.playxo to javafx.fxml;
    exports com.example.playxo;
}