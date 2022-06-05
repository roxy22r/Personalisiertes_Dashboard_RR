package com.example.personalisiertes_dashboard_rr;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Optional;

public class GetAJokeController {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

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
    public void onClickGetStockView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/example/personalisiertes_dashboard_rr/stock-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setWidth(scene.getWidth());
        stage.setHeight(scene.getHeight());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onClickShowAJoke(ActionEvent event) throws IOException {
        Text text = new Text();
        text.setStyle("-fx-font: 24 arial;");
        Alert dialog = new Alert(Alert.AlertType.NONE);
        dialog.setContentText("A Joke");
        dialog.setResizable(false);
        dialog.initStyle(StageStyle.UTILITY);
        dialog.getDialogPane().setMinSize(900, 330);
        dialog.getDialogPane().setPrefSize(900, 330);
        dialog.getDialogPane().setStyle("-fx-background-color: #97d1a4;");
        ButtonType OK = new ButtonType("OK");
        dialog.getButtonTypes().setAll(OK);
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.get() == OK) {
            System.out.println("Approve Button is clicked");
        }


    }
}
