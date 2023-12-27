package com.gmail.sizeeq.input;

import com.gmail.sizeeq.config.Config;
import com.gmail.sizeeq.messages.Messages;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NumberReceiver {
    public Set<Integer> getNumbersFromUser(Scanner scanner) {
        Set<Integer> givenNumbers = getUserInput(scanner);
        scanner.close();
        return givenNumbers;
    }

    private Set<Integer> getUserInput(Scanner scanner) {
        final Set<Integer> givenNumbers = new HashSet<>();
        System.out.println(Messages.ENTER_NUMBERS);
        while (!hasUserGaveSixNumbers(givenNumbers)) {
            System.out.println(Messages.ENTER_NUMBER);
            final int userInput = scanner.nextInt();
            if (isNumberValid(userInput)) {
                givenNumbers.add(userInput);
            } else {
                System.out.println(Messages.NUMBER_NOT_IN_RANGE);
            }
        }
        return givenNumbers;
    }

    private boolean hasUserGaveSixNumbers(Set<Integer> numbersFromUser) {
        return numbersFromUser.size() == Config.NUMBERS_FROM_USER;
    }

    private boolean isNumberValid(int givenNumber) {
        return isPositive(givenNumber) && isInRange(givenNumber);
    }

    private boolean isPositive(int givenNumber) {
        return givenNumber >= 0;
    }

    private boolean isInRange(int givenNumber) {
        return givenNumber >= Config.LOWER_BOUND && givenNumber <= Config.UPPER_BOUND;
    }
}
