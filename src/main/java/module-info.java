module com.example.to_see_working_one {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.jfoenix;


    opens com.example.to_see_working_one to javafx.fxml;
    exports com.example.to_see_working_one;
    exports controller;
    opens controller to javafx.fxml;
}