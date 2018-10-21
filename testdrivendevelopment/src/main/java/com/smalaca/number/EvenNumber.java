package com.smalaca.number;

class EvenNumber {
    private final int number;

    EvenNumber(int number) {
        if (isOdd(number)){
            throw new NotEvenNumberException();
        }

        this.number = number;
    }

    private boolean isOdd(int number) {
        return number % 2 != 0;
    }

    boolean isEven() {
        return number % 2 == 0;
    }
}
