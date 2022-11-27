package ch.rr.joke.model;

import java.util.ArrayList;
import java.util.List;

public class Joke {
    List<Joke> jokes = new ArrayList<>();
    private String text;

    public Joke() {

    }

    public Joke(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
