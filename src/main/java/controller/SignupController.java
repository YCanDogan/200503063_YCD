package controller;

import Database.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignupController<PasswordField> {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField signUpEmail;

    @FXML
    private TextField signUpFirstName;

    @FXML
    private TextField signUpLastName;

    @FXML
    public TextField signUpPassword;

    @FXML
    private TextField signUpPhoneNumber;

    @FXML
    private TextField signUpUserName;

    @FXML
    void initialize() {

        DatabaseHandler databaseHandler = new DatabaseHandler();

        // lambda function
        signUpButton.setOnAction(event -> {
            databaseHandler.signUpUser(signUpFirstName.getText(),
                    signUpLastName.getText(),
                    signUpUserName.getText(),
                    signUpPassword.getText(),
                    signUpEmail.getText(),
                    signUpPhoneNumber.getText());
        });

    }

}
