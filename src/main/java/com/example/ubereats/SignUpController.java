package com.example.ubereats;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class SignUpController {
    @FXML
    private Button btnBack;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnSignUp;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    private Label lblLoginUserNotFound;

    @FXML
    private Label lblSignUpTakenUsername;

    @FXML
    private Label lblLoginWrongPassword;

    private static ArrayList<User> users = new ArrayList<>();
    private static User user;
    private static boolean isLoggedIn;

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static User getUser() {
        return user;
    }

    public static boolean isIsLoggedIn() {
        return isLoggedIn;
    }

    public static void setIsLoggedIn(boolean isLoggedIn) {
        SignUpController.isLoggedIn = isLoggedIn;
    }

    private final Stage stage = new Stage();
    private Parent root;


    @FXML
    protected void BtnBack() throws IOException {
        Stage currentStage = (Stage) btnBack.getScene().getWindow();
        currentStage.close();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        stage.setTitle("Welcome to Uber Eats");
        stage.setScene(new Scene(root));
        stage.show();
        stage.setResizable(false);
    }

    @FXML
    protected void BtnSignUp() throws IOException {
        clear();
        User enteredUser = getInfo();
        User user = users.stream().filter(u -> Objects.equals(u.getUsername(), enteredUser.getUsername())).findFirst().orElse(null);
        if (user != null) {
            lblSignUpTakenUsername.setVisible(true);
        } else {
            isLoggedIn = true;
            users.add(enteredUser);
            SignUpController.user = enteredUser;
            BtnBack();
        }
    }

    @FXML
    protected void BtnLogin() throws IOException {
        clear();
        User enteredUser = getInfo();
        User user = users.stream().filter(u -> Objects.equals(u.getUsername(), enteredUser.getUsername())).findFirst().orElse(null);
        if (user == null) {
            lblLoginUserNotFound.setVisible(true);
        } else {
            if (!Objects.equals(user.getPassword(), enteredUser.getPassword())) {
                lblLoginWrongPassword.setVisible(true);
            } else {
                isLoggedIn = true;
                SignUpController.user = enteredUser;
                BtnBack();
            }
        }
    }

    private User getInfo() {
        return new User(txtUsername.getText(), txtPassword.getText());
    }

    private void clear() {
        user = null;
        lblSignUpTakenUsername.setVisible(false);
        lblLoginUserNotFound.setVisible(false);
        lblLoginWrongPassword.setVisible(false);
    }

}
