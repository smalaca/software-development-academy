package com.smalaca.number;

import org.junit.Assert;
import org.junit.Test;

public class NotEvenNumberExceptionTest {
    @Test
    public void shouldReturnMessageNumber() {
        //given
        int number = 17;
        NotEvenNumberException exception = new NotEvenNumberException(number);

        //when
        String message = exception.getMessage();

        //then
        Assert.assertEquals("Given number is not even: 17", message);
    }
}