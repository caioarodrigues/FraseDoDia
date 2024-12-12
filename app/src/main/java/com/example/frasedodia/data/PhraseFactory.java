package com.example.frasedodia.data;

import com.example.frasedodia.data.Phrase;
import java.util.ArrayList;

public class PhraseFactory {
    private static PhraseFactory _instance;
    private int _previousRandomIndexUsed = -1;
    private final ArrayList<Phrase> _phrases = new ArrayList<>();
    private PhraseFactory() {}
    public static PhraseFactory getInstance() {
        if (_instance == null)
            _instance = new PhraseFactory();

        return _instance;
    }
    public void add(String phrase) {
        if (this._phrases.size() + 1 < 10)
            throw new ExceptionInInitializerError("this phrases list must contain at least 10 items! ");

        var newPhrase = new Phrase(phrase);

        this._phrases.add(newPhrase);
    }
    public void add(ArrayList<String> phrases) {
        if (this._phrases.size() + phrases.size() < 10)
            throw new ExceptionInInitializerError("this phrases list must contain at least 10 items! ");

        for(var phrase : phrases) {
            var newPhrase = new Phrase(phrase);

            this._phrases.add(newPhrase);
        }
    }
    public ArrayList<Phrase> getPhrases() {
        return new ArrayList<>(this._phrases);
    }
    public String getRandomPhrase() {
        if (this._phrases.isEmpty()) {
            throw new IllegalStateException("The list is empty.");
        }

        int randomIndex;
        boolean repeatedPhrase;

        do {
            randomIndex = (int) (Math.random() * this._phrases.size());
            String phrase = this._phrases.get(randomIndex).getPhrase();

            repeatedPhrase = (_previousRandomIndexUsed != -1
                    && randomIndex == _previousRandomIndexUsed);

        } while (repeatedPhrase && this._phrases.size() > 1);

        _previousRandomIndexUsed = randomIndex;
        this._phrases.get(randomIndex).toggleSelectedStatus();
        return this._phrases.get(randomIndex).getPhrase();
    }
}
