package com.smalaca.foobar;

import org.junit.Assert;
import org.junit.Test;

public class FooBarTest {
    @Test
    public void shouldReturnStringIntRepresentationWhenPutInt() {
        //given
        int x = 1;
        
        //when
        String z = new FooBar().convertToString(x);

        //then
        Assert.assertEquals("1", z);
    }
}
