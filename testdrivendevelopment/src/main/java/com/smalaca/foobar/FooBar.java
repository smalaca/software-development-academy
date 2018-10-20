package com.smalaca.foobar;

class FooBar {
    String convertToString(int number) {
        if (number % 3 == 0) {
            return "Foo";
        }

        return String.valueOf(number);
    }
}
