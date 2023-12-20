module com.example.ultraduker {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ultraduker to javafx.fxml;
    exports com.example.ultraduker;
}