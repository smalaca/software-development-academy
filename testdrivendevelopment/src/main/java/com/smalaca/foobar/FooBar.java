package com.smalaca.foobar;

class FooBar {
    private static final String REPRESENTATION_DIVIDABLE_BY_THREE = "Foo";
    private static final String REPRESENTATION_DIVIDABLE_BY_FIVE = "Bar";

    String convertToString(int number) {
        if (number % 15 == 0) {
            return REPRESENTATION_DIVIDABLE_BY_THREE + REPRESENTATION_DIVIDABLE_BY_FIVE;
        }

        if (number % 5 == 0) {
            return REPRESENTATION_DIVIDABLE_BY_FIVE;
        }

        if (number % 3 == 0) {
            return REPRESENTATION_DIVIDABLE_BY_THREE;
        }

        return String.valueOf(number);
    }
}
