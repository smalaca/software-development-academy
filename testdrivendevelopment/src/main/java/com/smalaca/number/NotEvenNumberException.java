package com.smalaca.number;

class NotEvenNumberException extends RuntimeException {
    NotEvenNumberException(int number) {
        super("Given number is not even: " + number);
    }
}
