package ch.rr.stock;

import ch.rr.calender.CalenderController;
import ch.rr.impressum.Impressum;
import ch.rr.joke.GetAJokeController;
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
    private static final String IMPRESSUM = "Company: RaXit\nResponsible person: Raksana Ravichandran\nLocation: Maurer 4877,34 Hummligenstrasse\nemail: RaXit@gmail.com";

    public static String VIEW_PATH = "/ch/rr/stock/stock-view.fxml";
    /*
     * Hier wird die Kalender Ansicht geladen
     * */
    @FXML
    public void onClickGetCalenderView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource(CalenderController.VIEW_PATH));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setWidth(scene.getWidth());
        stage.setHeight(scene.getHeight());
        stage.setScene(scene);
        stage.show();
    }

    /*
     * Hier wird die Joke Ansicht geladen
     * */
    @FXML
    public void onClickGetAJokeView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource(GetAJokeController.VIEW_PATH));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setWidth(scene.getWidth());
        stage.setHeight(scene.getHeight());
        stage.setScene(scene);
        stage.show();
    }

    /*
     * Mit dieser Funktion wird ein Impressum geladen
     * */
    @FXML
    public void showImpressum() {
        Impressum.showImpressum();
    }


}
