package com.example.frasedodia.data;

public class Phrase {
    private String _phrase = null;
    private boolean _selected = false;
    public Phrase (String phrase) {
        this._phrase = phrase;
    }
    public void toggleSelectedStatus () {
        this._selected = !this._selected;
    }
    public String getPhrase() {
        return this._phrase;
    }
    public boolean getSelectedStatus() {
        return this._selected;
    }
}
