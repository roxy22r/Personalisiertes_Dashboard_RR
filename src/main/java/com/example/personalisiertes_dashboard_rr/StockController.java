package com.example.personalisiertes_dashboard_rr;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Optional;

public class StockController {
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    private static final String IMPRESSUM = "Company: RaXi\nResponsible person: Raksana Ravichandran\nLocation: Maurer 4877,34 Hummligenstrasse\nemail: RaXit@gmail.com";

    @FXML
    public void onClickGetCalenderView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/example/personalisiertes_dashboard_rr/calender-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setWidth(scene.getWidth());
        stage.setHeight(scene.getHeight());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onClickGetAJokeView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/example/personalisiertes_dashboard_rr/getAJoke-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setWidth(scene.getWidth());
        stage.setHeight(scene.getHeight());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void showImpressum() {
        Text text = new Text();
        text.setStyle("-fx-font: 30 arial;");
        text.setStyle("-fx-font-weight:bold;");
        text.setTextAlignment(TextAlignment.CENTER);
        Alert dialog = new Alert(Alert.AlertType.NONE);
        dialog.setTitle("Impressum");
        dialog.setContentText(IMPRESSUM);
        dialog.setResizable(false);
        dialog.initStyle(StageStyle.UTILITY);
        dialog.getDialogPane().setMinSize(500, 230);
        dialog.getDialogPane().setPrefSize(500, 230);
        dialog.getDialogPane().setStyle("-fx-background-color: #97d1a4;");
        dialog.getDialogPane().getScene().setFill(Color.WHITE);
        ButtonType OK = new ButtonType("OK");
        dialog.getButtonTypes().setAll(OK);
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.get() == OK) {
            System.out.println("Approve Button is clicked");
        }
    }


}
