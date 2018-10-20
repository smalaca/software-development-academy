package com.smalaca.wordcounter;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    private static final int NO_WORD_ACCEPTED = 0;

    private final Map<String, Integer> words = new HashMap<>();

    public int count(String word) {
        return words.getOrDefault(word, NO_WORD_ACCEPTED);
    }

    public void accept(String word) {
        words.put(word, count(word) + 1);
    }
}
