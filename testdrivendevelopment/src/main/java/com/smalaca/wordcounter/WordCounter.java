package com.smalaca.wordcounter;

public class WordCounter {
    private boolean accepted;

    public int count(String word) {
        return accepted ? 1 : 0;
    }

    public void accept(String word) {
        accepted = true;
    }
}
