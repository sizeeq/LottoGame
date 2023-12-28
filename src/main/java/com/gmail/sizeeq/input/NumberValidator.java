package com.gmail.sizeeq.input;

import com.gmail.sizeeq.config.Config;

public class NumberValidator {
    public boolean isNumberValid(int givenNumber) {
        return isPositive(givenNumber) && isInRange(givenNumber);
    }

    private boolean isPositive(int givenNumber) {
        return givenNumber >= 0;
    }

    private boolean isInRange(int givenNumber) {
        return givenNumber >= Config.LOWER_BOUND && givenNumber <= Config.UPPER_BOUND;
    }
}
