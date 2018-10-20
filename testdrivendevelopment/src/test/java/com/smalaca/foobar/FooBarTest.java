package com.smalaca.foobar;

import org.junit.Assert;
import org.junit.Test;

public class FooBarTest {
    private static final int NUMBER = 1;
    private static final String EXPECTED_REPRESENTATION = "1";

    @Test
    public void shouldReturnStringIntRepresentationWhenPutInt() {
        //given

        //when
        String result = new FooBar().convertToString(NUMBER);

        //then
        Assert.assertEquals(EXPECTED_REPRESENTATION, result);
    }

    @Test
    public void shouldReturnStringFooWhenIntIsDividableByThree() {
        //given
        int number = 3;

        //when
        String result = new FooBar().convertToString(number);

        //then
        Assert.assertEquals("Foo", result);
    }
}
