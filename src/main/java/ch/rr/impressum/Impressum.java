package ch.rr.impressum;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.StageStyle;

import java.util.Optional;

public class Impressum {
    private static final String IMPRESSUM = "Company: RaXit\nResponsible person: Raksana Ravichandran\nLocation: Maurer 4877,34 Hummligenstrasse\nemail: RaXit@gmail.com";

    public static void showImpressum() {
        Text text = new Text();
        text.setStyle("-fx-font: 30 arial;");
        text.setStyle("-fx-font-weight:bold;");
        text.setTextAlignment(TextAlignment.CENTER);
        Alert dialog = new Alert(Alert.AlertType.NONE);
        dialog.setTitle("Impressum");
        dialog.setContentText(IMPRESSUM);
        dialog.setResizable(false);
        dialog.initStyle(StageStyle.UNDECORATED);
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
