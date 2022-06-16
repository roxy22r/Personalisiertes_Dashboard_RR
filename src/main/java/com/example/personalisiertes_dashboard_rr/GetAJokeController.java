package com.example.personalisiertes_dashboard_rr;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.*;

public class GetAJokeController {
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    private List<String> Jokes = new ArrayList<>(Arrays.asList(
            "A woman gets on a bus with her baby. The bus driver says: 'Ugh, that’s the ugliest baby I’ve ever seen!' The woman walks to the rear of the bus and sits down, fuming. She says to a man next to her: “The driver just insulted me!' The man says: 'You go up there and tell him off. Go on, I’ll hold your monkey for you.'",
            "I said to the Gym instructor 'Can you teach me to do the splits?'He said, “How flexible are you?' I said, 'I can’t make Tuesdays.'",
            "Police arrested two kids yesterday, one was drinking battery acid, the other was eating fireworks. They charged one – and let the other one off."));

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
        dialog.setContentText(getRandomJoke());
        dialog.setResizable(false);
        dialog.initStyle(StageStyle.UTILITY);
        dialog.getDialogPane().setMinSize(500, 330);
        dialog.getDialogPane().setPrefSize(500, 330);
        dialog.getDialogPane().setStyle("-fx-background-color: #97d1a4;");
        dialog.getDialogPane().getScene().setFill(Color.WHITE);
        ButtonType OK = new ButtonType("OK");
        dialog.getButtonTypes().setAll(OK);
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.get() == OK) {
            System.out.println("Approve Button is clicked");
        }
    }

    private String getRandomJoke() {
        Random random = new Random();
        int index = random.nextInt(Jokes.size());
        return Jokes.get(index);
    }

    @FXML
    public void onClickAddAJoke(ActionEvent event) {
        GridPane grid = new GridPane();
        Label label = new Label();
        label.setText("Text of Joke:");
        TextArea textArea = new TextArea();
        textArea.setStyle("-fx-background-color: white;");

        Alert dialog = new Alert(Alert.AlertType.NONE);
        dialog.setResizable(false);
        dialog.initStyle(StageStyle.UTILITY);

        dialog.getDialogPane().getScene().setFill(Color.BLACK);
        dialog.getDialogPane().setMinSize(500, 330);
        dialog.getDialogPane().setPrefSize(500, 330);
        dialog.getDialogPane().setStyle("-fx-background-color: #97d1a4;");
        ButtonType create = new ButtonType("create");
        dialog.getButtonTypes().setAll(create);
        dialog.getDialogPane().setContent(grid);
        grid.add(label, 0, 0);
        grid.add(textArea, 0, 1, 10, 7);

        validateUserInput(label, textArea, dialog, create);
    }

    private void validateUserInput(Label label, TextArea textArea, Alert dialog, ButtonType create) {
        Optional<ButtonType> result = dialog.showAndWait();
        try {
            if (result.get() == create && !textArea.getText().isEmpty()) {
                Jokes.add(textArea.getText());
            } else if (textArea.getText().isEmpty()) {
                label.setText("You have to do a Input in Text Area");
                dialog.getDialogPane().setContent(label);
                textArea.setStyle("-fx-border-color: #f73c28;");
                dialog.show();
            }
        } catch (Exception e) {
            System.out.println("Dialog was closed ->" + e);
        }
    }

    @FXML
    public void showImpressum() {
        Text text = new Text();
        text.setStyle("-fx-font: 30 arial;");
        text.setStyle("-fx-font-weight:bold;");
        text.setTextAlignment(TextAlignment.CENTER);
        Alert dialog = new Alert(Alert.AlertType.NONE);
        dialog.setTitle("Impressum");
        dialog.setContentText("Company: RaXi\nResponsible person: Raksana Ravichandran\nLocation: Maurer 4877,34 Hummligenstrasse\nemail: RaXit@gmail.com");
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