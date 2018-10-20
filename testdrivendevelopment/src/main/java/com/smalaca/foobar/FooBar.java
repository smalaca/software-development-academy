package com.smalaca.foobar;

class FooBar {
    private static final String REPRESENTATION_DIVIDABLE_BY_THREE = "Foo";

    String convertToString(int number) {
        if (number % 3 == 0) {
            return REPRESENTATION_DIVIDABLE_BY_THREE;
        }

        return String.valueOf(number);
    }
}
