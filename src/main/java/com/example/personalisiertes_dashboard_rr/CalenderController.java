package com.example.personalisiertes_dashboard_rr;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;


public class CalenderController {
    @FXML
    private Label welcomeText;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void onClickGetAJoke(ActionEvent event) throws IOException {




    }

}