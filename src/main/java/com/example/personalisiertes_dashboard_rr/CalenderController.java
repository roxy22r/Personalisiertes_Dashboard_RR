package com.example.personalisiertes_dashboard_rr;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.*;


public class CalenderController implements Initializable {
    Label response;
    @FXML
    private Stage stage = new Stage();
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private GridPane calenderGrid;
    private static final String IMPRESSUM = "Company: RaXi\nResponsible person: Raksana Ravichandran\nLocation: Maurer 4877,34 Hummligenstrasse\nemail: RaXit@gmail.com";
    @FXML
    private ComboBox peopleDirectory;
    String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    int mothSlideCount = 0;
    @FXML
    private Label monthLabel;
    @FXML
    private Pane appointmentsOftTheDay;
    Owner owner = new Owner("Emma", "Whatson");
    private Person person = owner;


    private List<Appointment> appointments = new ArrayList<>(Arrays.asList(
            new Appointment("Project abgabe", LocalDateTime.of(2022, Month.JUNE, 5, 0, 0), LocalTime.of(12, 0), LocalTime.of(15, 0), " Abgabe von Abu Projekt"),
            new Appointment("Arduino Projekt", LocalDateTime.of(2022, Month.JUNE, 10, 0, 0), LocalTime.of(7, 0), LocalTime.of(8, 0), " Abgabe Aruino Projekt idee"),
            new Appointment("Preasentation DonT Guess The Word 2ice", LocalDateTime.of(2022, Month.JUNE, 25, 0, 0), LocalTime.of(10, 0), LocalTime.of(14, 0), " Team arbeit preasentation"),
            new Appointment("Team event", LocalDateTime.of(2022, Month.JUNE, 20, 0, 0), LocalTime.of(17, 0), LocalTime.of(19, 0), " Event"),
            new Appointment("Abschlussfeier", LocalDateTime.of(2022, Month.JULY, 4, 0, 0), LocalTime.of(20, 0), LocalTime.of(22, 0), " Termin"),
            new Appointment("Ferien 234ZG", LocalDateTime.of(2022, Month.MAY, 25, 0, 0), LocalTime.of(10, 0), LocalTime.of(14, 0), " Team arbeit preasentation"),
            new Appointment("Film Abend", LocalDateTime.of(2022, Month.MAY, 20, 0, 0), LocalTime.of(17, 0), LocalTime.of(19, 0), " Event")
    ));

    private List<ProjectOwner> po = new ArrayList<>(Arrays.asList(
            new ProjectOwner("Tom", "Holland", LocalDateTime.of(2022, Month.JUNE, 7, 13, 30), LocalDateTime.of(2022, Month.JUNE, 7, 17, 15))
    ));

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setConboBox();
        reloadCalenderSlide();

    }

    private void setConboBox() {
        List<String> list = new ArrayList<String>();
        list.add("PO");
        list.add("Owner");
        list.add("Both");
        ObservableList obList = FXCollections.observableList(list);
        peopleDirectory.getSelectionModel().getSelectedIndex();
        peopleDirectory.setItems(obList);
    }

    @FXML
    private void showVisableAppointmentsOfPerson() {

        if (PersonKind.valueOf(peopleDirectory.getValue().toString()) == PersonKind.PO) {
            person = new ProjectOwner("", "");
        } else {
            person = owner;
        }
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
        reloadCalenderSlide();
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

    public long getTotalDaysMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
        LocalDateTime month = LocalDateTime.of(LocalDateTime.now().getYear(), LocalDateTime.now().plusMonths(mothSlideCount).getMonth(), 1, 0, 0);
        LocalDateTime beginn = LocalDateTime.of(LocalDateTime.now().getYear(), month.getMonth(), 1, 0, 0);
        LocalDateTime end = month.plusMonths(1).withDayOfMonth(1).minusDays(1);
        calendar.set(LocalDateTime.now().getYear(), month.getMonthValue(), 1, 0, 0, 0);


        setMonthLabelInCalender(month.getMonthValue());
        return beginn.until(end, ChronoUnit.DAYS);

    }

    public void reloadCalenderSlide() {
        try {
            int day = 1;
            int monthVisable = 0;
            Month month = LocalDateTime.now().plusMonths(mothSlideCount).getMonth();
            for (int row = 0; row < calenderGrid.getRowCount(); row++) {
                for (int colum = 0; colum < calenderGrid.getColumnCount(); colum++) {
                    removeLabelByRowColumnIndex(row, colum, calenderGrid);
                    removeButtonByRowColumnIndex(row, colum, calenderGrid);
                    Label label = new Label();
                    label.setText(String.valueOf(day));
                    Bounds cell = calenderGrid.getCellBounds(colum, row);
                    label.setPrefSize(cell.getWidth(), 10);
                    label.setAlignment(Pos.TOP_RIGHT);
                    label.setTextAlignment(TextAlignment.RIGHT);
                    label.setContentDisplay(ContentDisplay.TOP);
                    label.autosize();
                    calenderGrid.add(label, colum, row);
                    loadAppointments(calenderGrid, colum, row, cell, month, day);
                    if ((day - 1) == getTotalDaysMonth()) {
                        day = 1;
                    }
                    day++;
                }
            }
        } catch (Exception e) {
            System.out.println("reloadCalenderSlide->" + e);
        }
    }


    @FXML
    private void previousMonth() {
        try {
            Calendar calendar = Calendar.getInstance();
            Month month = LocalDateTime.now().minusMonths(mothSlideCount).getMonth();
            if (month.getValue() >= Month.JANUARY.getValue()) {
                mothSlideCount--;
                setMonthLabelInCalender(month.getValue());
                reloadCalenderSlide();
            }
        } catch (Exception e) {
            System.out.println("previousMonth->" + e);
        }
    }

    @FXML
    private void nextMonth() {
        try {
            Calendar calendar = Calendar.getInstance();
            Month month = LocalDateTime.now().plusMonths(mothSlideCount).getMonth();
            if (month.getValue() + 1 < Month.DECEMBER.getValue()) {
                mothSlideCount++;
                setMonthLabelInCalender(month.getValue());
                reloadCalenderSlide();
            }
        } catch (Exception e) {
            System.out.println("nextMonth" + e);
        }

    }

    private void setMonthLabelInCalender(int value) {
        this.monthLabel.setText(monthNames[value]);
    }

    private void loadAppointments(GridPane calenderGrid, int colum, int row, Bounds cell, Month month, int day) {
        for (Appointment appointment : person.getAppointments()) {

            if (appointment.getDate().getMonth() == month && appointment.getDate().getDayOfMonth() == day) {
                Button button = new Button();
                button.setMinSize(cell.getWidth(), 10);
                button.autosize();
                button.setText(appointment.getTitel());
                calenderGrid.add(button, colum, row);
            }
        }


    }


    private void loadAppointmentOftheDay(LocalDateTime date, Appointment appointmentOftheDay) {
        for (Appointment appointment : appointments) {
            {
                if (appointment.getDate().getMonth() == date.getMonth() && appointment.getDate().getDayOfMonth() == date.getDayOfMonth()) {
                    Button button = new Button();
                    button.autosize();
                    button.setOnAction(event -> showAppointmentInfo(event, appointment));
                    button.setText(appointment.getTitel());
                    appointmentsOftTheDay.getChildren().add(button);
                }
            }
        }
        appointmentsOftTheDay.setOpacity(1);
    }

    private void showAppointmentInfo(ActionEvent event, Appointment appointment) {
        //
        Button edit = new Button();
        edit.setText("edit");
        //
        String lightGreyStyle = "-fx-background-color: #9faabd;";
        GridPane grid = new GridPane();
        Label titeLabel = new Label();
        titeLabel.setText("Titel:");
        TextField textTitel = new TextField();
        textTitel.setText(appointment.getTitel());
        textTitel.setDisable(true);
        //
        textTitel.setStyle(lightGreyStyle);
        Label dateLabel = new Label();
        dateLabel.setText("Date:");
        Label durrationLabel = new Label();
        durrationLabel.setText("Durration");
        //
        DatePicker datePicker = new DatePicker();
        datePicker.setStyle(lightGreyStyle);
        datePicker.setValue(appointment.getDate().toLocalDate());
        datePicker.setDisable(true);
        //
        TextField textBeginn = new TextField();
        textBeginn.setStyle(lightGreyStyle);
        textBeginn.setText(appointment.getBegin().toString());
        textBeginn.setDisable(true);
        //
        TextField textEnd = new TextField();
        textEnd.setStyle(lightGreyStyle);
        textEnd.setText(appointment.getEnd().toString());
        textEnd.setDisable(true);
        //
        Label toLabel = new Label();
        toLabel.setText("to");
        TextArea textArea = new TextArea();
        textArea.setText(lightGreyStyle);
        textArea.setText(appointment.getNote());
        textArea.setDisable(true);
        Label noteLable = new Label();
        noteLable.setText("Note: ");
        textArea.setStyle("-fx-background-color: white;");
        //
        Alert dialog = new Alert(Alert.AlertType.NONE);
        dialog.setResizable(false);
        dialog.initStyle(StageStyle.UTILITY);
        //
        dialog.getDialogPane().getScene().setFill(Color.BLACK);
        dialog.getDialogPane().setMinSize(500, 330);
        dialog.getDialogPane().setPrefSize(500, 330);
        dialog.getDialogPane().setStyle("-fx-background-color: #97d1a4;");
        ButtonType ok = new ButtonType("OK");
        dialog.getButtonTypes().setAll(ok);
        dialog.getDialogPane().setContent(grid);
        grid.add(edit, 0, 0);
        grid.add(titeLabel, 0, 1);
        grid.add(textTitel, 2, 1);
        grid.add(dateLabel, 0, 4);
        grid.add(datePicker, 2, 4);
        grid.add(durrationLabel, 0, 5);
        grid.add(textBeginn, 2, 5);
        grid.add(toLabel, 3, 5);
        grid.add(textEnd, 4, 5);
        grid.add(noteLable, 0, 6);
        grid.add(textArea, 0, 7, 4, 4);
        //
        edit.setOnAction(appointmentEvent -> editAppointment(appointmentEvent, dialog, ok, textTitel, datePicker, textBeginn, textEnd, textArea));
        validateUserInput(dialog, ok, textTitel, datePicker, textBeginn, textEnd, textArea);
        reloadCalenderSlide();
    }

    private void editAppointment(ActionEvent event, Alert dialog, ButtonType ok, TextField textTitel, DatePicker datePicker, TextField textBeginn, TextField textEnd, TextArea textArea) {
        textTitel.setDisable(false);
        datePicker.setDisable(false);
        textBeginn.setDisable(false);
        textEnd.setDisable(false);
        textArea.setDisable(false);
        ok = new ButtonType("create");


    }

    public void removeButton(Button button) {
        root.getChildrenUnmodifiable().remove(button);
    }

    public void removeLabelByRowColumnIndex(final int row, final int column, GridPane gridPane) {

        ObservableList<Node> childrens = gridPane.getChildren();
        for (Node node : childrens) {
            if (node instanceof Label && gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                Label label = (Label) node;
                gridPane.getChildren().remove(label);
                break;
            }
        }
    }

    public void removeButtonByRowColumnIndex(final int row, final int column, GridPane gridPane) {
        ObservableList<Node> childrens = gridPane.getChildren();
        for (Node node : childrens) {
            if (node instanceof Button && gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                Button button = (Button) node;
                gridPane.getChildren().remove(button);
                break;
            }
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