package ch.rr.joke;

import ch.rr.impressum.Impressum;
import ch.rr.joke.model.Joke;
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
import javafx.scene.text.Font;
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

    public static String VIEW_PATH = "/ch/rr/joke/getAJoke-view.fxml";
    private List<Joke> jokes = new ArrayList<>(Arrays.asList(
            new Joke("A woman gets on a bus with her baby. The bus driver says: 'Ugh, that’s the ugliest baby I’ve ever seen!' The woman walks to the rear of the bus and sits down, fuming. She says to a man next to her: “The driver just insulted me!' The man says: 'You go up there and tell him off. Go on, I’ll hold your monkey for you.'"),
            new Joke("I said to the Gym instructor 'Can you teach me to do the splits?'He said, “How flexible are you?' I said, 'I can’t make Tuesdays.'"),
            new Joke("Police arrested two kids yesterday, one was drinking battery acid, the other was eating fireworks. They charged one – and let the other one off."),
            new Joke("What’s the smartest insect? A spelling bee!"),
            new Joke("How does the ocean say hi? It waves!"),
            new Joke("How does NASA organize a party?\nThey planet."),
            new Joke("There are two muffins baking in the oven. One muffin says to the other, “Phew, is it getting hot in here or is it just me?” The other muffin says, “AAAAHHH!! A TALKING MUFFIN!"),
            new Joke("My memory has gotten so bad it has actually caused me to lose my job. I’m still employed. I just can’t remember where."),
            new Joke("What does the zero say to the eight? A: Nice belt!"),
            new Joke("A patient came to the hospital with a burned right hand. As the doctor took down his medical history, he asked the injured man, “Do you smoke?” “Yeah, a pack..."),
            new Joke("What was Beethoven’s favorite fruit? BA-NA-NA-NAAAAAA."),
            new Joke("In Fort Worth, Texas, I was hauled before the judge for driving with expired license plates. The judge listened attentively while I gave him a long, plausible explanation.\n" +
                    "Then he said with great courtesy, \"My dear sir, we are not blaming you—we're just fining you.\""),
            new Joke("I got excited when my son joined the cross-country team. But then I learned they don't cross the country and are back home in a few hours."),
            new Joke("Q: If they hold a pie eating contest this holiday season, which song will they sing? \nA: Oh, Come all ye facefuls."),
            new Joke("Q: What do you call a snowman that can walk? A: Snow-mobile"),
            new Joke("Q: Why is Cinderella so bad at soccer? \nA: Because she always runs away from the ball!"),
            new Joke("Q: Why is Peter Pan flying all the time?\n A: He Neverlands!"),
            new Joke("Q: Why aren't dogs good dancers? A. Because they have two left feet!"),
            new Joke("Who’s there?\nTheodore.\nTheodore who?\nTheodore wasn’t opened so I knocked."),
            new Joke("What kind of dog does a magician have?\n best jokes for kids\n A Labracadabrador!")
    ));

    /*
     * Hier wird die Kalender Ansicht geladen
     * */
    @FXML
    public void onClickGetCalenderView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/ch/rr/calender/calender-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setWidth(scene.getWidth());
        stage.setHeight(scene.getHeight());
        stage.setScene(scene);
        stage.show();
    }

    /*
     * Hier wird die Stock Ansicht geladen
     * */
    @FXML
    public void onClickGetStockView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/ch/rr/stock/stock-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setWidth(scene.getWidth());
        stage.setHeight(scene.getHeight());
        stage.setScene(scene);
        stage.show();
    }

    /*
     * Hier wir ein Dialog geladen für ein Witz , dass Angezeigt wird.
     * */
    @FXML
    public void onClickShowAJoke(ActionEvent event) throws IOException {
        Text text = new Text();
        text.setStyle("-fx-font: 24 arial;");
        Alert dialog = new Alert(Alert.AlertType.NONE);
        dialog.setContentText(getRandomJoke().getText());
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

    /*
     * Hier wird Zufällig ein Witz geholt
     * */
    private Joke getRandomJoke() {
        Random random = new Random();
        int index = random.nextInt(jokes.size());
        return jokes.get(index);
    }

    /*
     * Hier wird ein Wid ein Dialog geladen um ein Witz Hinzuzufügen
     * */
    @FXML
    public void onClickAddAJoke(ActionEvent event) {
        GridPane grid = new GridPane();
        Label label = new Label();
        label.setText("Text of Joke:");
        TextArea textArea = new TextArea();
        textArea.setStyle("-fx-background-color: white;");

        Alert dialog = new Alert(Alert.AlertType.NONE);
        dialog.setResizable(false);
        dialog.initStyle(StageStyle.UNDECORATED);
        dialog.getDialogPane().getButtonTypes().remove(ButtonType.CANCEL);
        dialog.getDialogPane().getScene().setFill(Color.BLACK);
        dialog.getDialogPane().setMinSize(500, 330);
        dialog.getDialogPane().setPrefSize(500, 330);
        dialog.getDialogPane().setStyle("-fx-background-color: #97d1a4;");
        ButtonType create = new ButtonType("create");
        dialog.getButtonTypes().setAll(create);
        dialog.getDialogPane().setContent(grid);

        grid.add(textArea, 0, 2, 5, 5);
        grid.add(label, 0, 0);
        validateUserInput(label, textArea, dialog, create);
    }

    /*
     * Hier wird die Nutzer eingabe Validiert, ob der Text leer ist oder nicht
     * */
    private void validateUserInput(Label label, TextArea textArea, Alert dialog, ButtonType create) {
        Optional<ButtonType> result = dialog.showAndWait();
        try {
            if (result.get() == create && !textArea.getText().isEmpty()) {
                jokes.add(new Joke(textArea.getText()));
            } else if (textArea.getText().isEmpty()) {
                label.setText("You have to do a Input in Text Area");
                dialog.getDialogPane().lookupButton(create);
                textArea.setStyle("-fx-border-color: #f73c28;");
                dialog.show();
            }
        } catch (Exception e) {
            System.out.println("Dialog was closed ->" + e);
        }
    }

    /*
     * Mit dieser Funktion wird ein Impressum geladen
     * */
    @FXML
    public void showImpressum() {
        Impressum.showImpressum();
    }
}