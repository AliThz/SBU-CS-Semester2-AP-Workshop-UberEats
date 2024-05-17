package com.example.ubereats;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.scene.control.TextField;
public class HelloController implements Initializable {
    @FXML
    private ImageView ImageId;

    @FXML
    private TextField search_text;
    @FXML
    private Button btnSignUp;

    @FXML
    private Button btnFoods;

    @FXML
    private Button btnLogOut;

    @FXML
    private Label lblWelcomeUser;

    private Parent root;
    private Scene scene;
    private Stage stage = new Stage();

    @FXML
    protected void search_function() {
        System.out.println(search_text.getText());
    }

    @FXML
    protected void SignUp_Function() throws IOException {
        Stage currentStage = (Stage) btnSignUp.getScene().getWindow();
        currentStage.close();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("signup.fxml")));
        stage.setTitle("Welcome to Uber Eats");
        stage.setScene(new Scene(root));
        stage.show();
        stage.setResizable(false);
    }

    @FXML
    protected void Logout_Function() throws IOException {
        SignUpController.setIsLoggedIn(false);
        btnSignUp.setVisible(true);
        lblWelcomeUser.setText("Hi !");
        lblWelcomeUser.setVisible(false);
        btnLogOut.setVisible(false);
    }

    @FXML
    protected void Foods_Function() throws IOException {
        Stage currentStage = (Stage) btnFoods.getScene().getWindow();
        currentStage.close();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AllFoods.fxml")));
        stage.setTitle("Welcome to Uber Eats");
        stage.setScene(new Scene(root));
        stage.show();
        stage.setResizable(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (SignUpController.isIsLoggedIn()) {
            btnSignUp.setVisible(false);
            lblWelcomeUser.setText("Hi " + SignUpController.getUser().getUsername() + " !");
            lblWelcomeUser.setVisible(true);
            btnLogOut.setVisible(true);
        }
    }
}