package controller;

import Database.DatabaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXComboBox;
import model.Admin;

public class LoginController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button loginButton;

    @FXML
    private Button loginSignupButton;

    @FXML
    private PasswordField password;

    @FXML
    private TextField userName;

    @FXML
    private JFXComboBox<?> comboBox;

    private static String comboboxvalue;

    @FXML
    void initialize() {

        try {
            DatabaseHandler.connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
/*
        ObservableList userKind = FXCollections.observableArrayList("Admin","Employee");
        comboBox.setItems(userKind);
        comboBox.getSelectionModel().selectFirst();

*/


        loginSignupButton.setOnAction(event -> {
            // Take users to sign up string
            loginSignupButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/to_see_working_one/signUp.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

        });

        loginButton.setOnAction(event -> {
            Admin admin = new Admin();
            String loginText = userName.getText().trim();
            String loginPwd = password.getText().trim();
            if (!loginText.equals("") || !loginPwd.equals("")) {

                admin.setUsername(loginText);
                admin.setPassword(loginPwd);

                ResultSet adminRow = DatabaseHandler.getAdmin(admin);
                int counter = 0;
                    while(true) {
                        try {
                            if (!adminRow.next()){
                                if (counter == 1) {
                                    showMainScreen();
                                    break;
                                }else{
                                    System.out.println("Wrong Password");
                                    break;
                                }
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        counter++;
                    }


            }

        });

    }

    private void showMainScreen(){
        loginButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("\"/com/example/to_see_working_one/addItem.fxml\""));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    private void loginUser(String userName, String password) {


        // Check in the database if the user exists, if true
        // we take them to AddItem Screen
    }
}