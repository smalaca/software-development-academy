package com.smalaca.wordcounter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCounterTest {
    private static final String WORD = "word";

    @Test
    public void shouldRecognizeThatGivenWordWasNeverAccepted() {
        int result = new WordCounter().count(WORD);

        assertEquals(0, result);
    }
}
