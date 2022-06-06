package com.example.personalisiertes_dashboard_rr;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;


public class CalenderController {
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private GridPane calenderGrid;
    private Month month = Month.of(Calendar.MONTH);

    private List<Appointment> appointments = new ArrayList<>(Arrays.asList(
            new Appointment("Project abgabe", LocalDateTime.of(2022, Month.JUNE, 5, 0, 0), LocalTime.of(12, 0), LocalTime.of(15, 0), " Abgabe von Abu Projekt"),
            new Appointment("Arduino Projekt", LocalDateTime.of(2022, Month.JUNE, 10, 0, 0), LocalTime.of(7, 0), LocalTime.of(8, 0), " Abgabe Aruino Projekt idee"),
            new Appointment("Preasentation DonT Guess The Word 2ice", LocalDateTime.of(2022, Month.JUNE, 25, 0, 0), LocalTime.of(10, 0), LocalTime.of(14, 0), " Team arbeit preasentation"),
            new Appointment("Team event", LocalDateTime.of(2022, Month.JUNE, 20, 0, 0), LocalTime.of(17, 0), LocalTime.of(19, 0), " Event"),
            new Appointment("Abschlussfeier", LocalDateTime.of(2022, Month.JULY, 4, 0, 0), LocalTime.of(20, 0), LocalTime.of(22, 0), " Termin")
    ));

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
    public void addAppointment() throws IOException {
        GridPane grid = new GridPane();
        Label titeLabel = new Label();
        titeLabel.setText("Titel:");
        TextField textTitel = new TextField();
        Label dateLabel = new Label();
        dateLabel.setText("Date:");
        Label durrationLabel = new Label();
        durrationLabel.setText("Durration");
        DatePicker datePicker = new DatePicker();
        TextField textBeginn = new TextField();
        TextField textEnd = new TextField();
        Label toLabel = new Label();
        toLabel.setText("to");
        TextArea textArea = new TextArea();
        Label noteLable = new Label();
        noteLable.setText("Note: ");
        textArea.setStyle("-fx-background-color: white;");

        Alert dialog = new Alert(Alert.AlertType.NONE);
        dialog.setResizable(false);
        dialog.initStyle(StageStyle.UTILITY);

        dialog.getDialogPane().getScene().setFill(Color.BLACK);
        dialog.getDialogPane().setMinSize(500, 330);
        dialog.getDialogPane().setPrefSize(500, 330);
        dialog.getDialogPane().setStyle("-fx-background-color: #97d1a4;");
        ButtonType create = new ButtonType("create");
        boolean testttt = create.getButtonData().isDefaultButton();
        dialog.getButtonTypes().setAll(create);
        dialog.getDialogPane().setContent(grid);
        grid.add(titeLabel, 0, 0);
        grid.add(textTitel, 1, 0);
        grid.add(dateLabel, 0, 4);
        grid.add(datePicker, 1, 4);
        grid.add(durrationLabel, 0, 5);
        grid.add(textBeginn, 1, 5);
        grid.add(toLabel, 2, 5);
        grid.add(textEnd, 3, 5);
        grid.add(noteLable, 0, 6);
        grid.add(textArea, 0, 7, 6, 6);


        validateUserInput(dialog, create, textTitel, datePicker, textBeginn, textEnd, textArea);
    }

    private void validateUserInput(Alert dialog, ButtonType create, TextField textTitel, DatePicker datePicker, TextField textBeginn, TextField textEnd, TextArea textArea) {
        Optional<ButtonType> result = dialog.showAndWait();
        try {
            if (result.get() == create && !textArea.getText().isEmpty()) {
                Appointment appointment = new Appointment(textTitel.getText(), datePicker.getValue(), textBeginn.getText(), textEnd.getText(), textArea.getText());
                appointments.add(appointment);

            } else if (textArea.getText().isEmpty()) {
                dialog.show();
            }
        } catch (Exception e) {
            System.out.println("Dialog was closed ->" + e);
        }
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

    public void creatCalender() throws IOException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
        int monthCount = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int day = 1;
        int month = 0;

        for (int row = 0; row < calenderGrid.getRowCount(); row++) {
            for (int colum = 0; colum < calenderGrid.getColumnCount(); colum++) {

                Label label = new Label();
                label.setText(String.valueOf(day));
                Bounds cell = calenderGrid.getCellBounds(colum, row);
                label.setPrefSize(cell.getWidth(), 10);
                label.setAlignment(Pos.TOP_RIGHT);
                label.setTextAlignment(TextAlignment.RIGHT);
                label.setContentDisplay(ContentDisplay.TOP);
                label.autosize();
                loadAppointments(calenderGrid, colum, row, cell, month, day);
                calenderGrid.add(label, colum, row);
                day++;
                //  calenderGrid.getCellBounds(row,colum).
                if (day == monthCount) {
                    day = 1;
                    month++;
                }

            }
        }


    }

    private void loadAppointments(GridPane calenderGrid, int colum, int row, Bounds cell, int month, int day) {
        for (Appointment appointment : appointments) {
            if (appointment.getDate().getDayOfMonth() == day && appointment.getDate().getMonth() == LocalDateTime.now().getMonth().plus(month)) {
                Button button = new Button();
                button.setMinSize(cell.getWidth(), 10);
                button.autosize();
                button.setText(appointment.getTitel());
                calenderGrid.add(button, colum, row);
            }
        }
    }


}