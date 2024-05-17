package com.example.ubereats;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class FoodsController {

    @FXML
    private Button btnBack;
    @FXML
    private Button btnOrder;

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

}
