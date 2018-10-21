package com.smalaca.number;

import org.junit.Assert;
import org.junit.Test;

public class EvenNumberTest {
    @Test
    public void shouldRecognizeWhenNumberIsEven() {
        //given
        int number = 2;
        EvenNumber evenNumber = new EvenNumber(number);

        //when
        boolean isEven = evenNumber.isEven();

        //then
        Assert.assertTrue(isEven);
    }
}
