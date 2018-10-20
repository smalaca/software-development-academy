package com.smalaca.wordcounter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCounterTest {
    private static final String WORD = "word";
    private static final String DIFFERENT_WORD = "different word";

    @Test
    public void shouldRecognizeThatGivenWordWasNeverAccepted() {
        int result = new WordCounter().count(WORD);

        assertEquals(0, result);
    }

    @Test
    public void shouldRecognizeWhenWordWasGiven() {
        WordCounter wordCounter = new WordCounter();
        wordCounter.accept(WORD);

        int result = wordCounter.count(WORD);

        assertEquals(1, result);
    }

    @Test
    public void shouldRecognizeWhenWordWasGivenMultipleTimes() {
        WordCounter wordCounter = new WordCounter();
        wordCounter.accept(WORD);
        wordCounter.accept(WORD);

        int result = wordCounter.count(WORD);

        assertEquals(2, result);
    }

    @Test
    public void shouldCountWordsWhenManyWordsGiven() {
        WordCounter wordCounter = new WordCounter();
        wordCounter.accept(WORD);
        wordCounter.accept(WORD);
        wordCounter.accept(DIFFERENT_WORD);

        int result = wordCounter.count(WORD);

        assertEquals(2, result);
    }
}
