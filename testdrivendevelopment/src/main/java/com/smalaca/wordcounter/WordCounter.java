package com.smalaca.wordcounter;

import java.util.ArrayList;
import java.util.List;

public class WordCounter {
    private List<String> words = new ArrayList<>();

    public int count(String word) {
        return (int) words.stream().filter(word::equals).count();
    }

    public void accept(String word) {
        words.add(word);
    }
}
