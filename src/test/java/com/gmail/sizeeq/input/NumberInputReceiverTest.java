package com.gmail.sizeeq.input;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NumberInputReceiverTest {

    final NumberInputReceiver numberInputReceiver = new NumberInputReceiver();

    @Test
    void should_return_set_with_six_numbers_when_all_input_numbers_in_range() {
        //given
        Set<Integer> expectedNumbers = Set.of(10, 20, 30, 40, 50, 60);
        String userTextInput = "10 20 30 40 50 60";
        Scanner userInputScanner = getScannerFromString(userTextInput);

        //when
        final Set<Integer> userInputNumbers = numberInputReceiver.getNumbersFromUser(userInputScanner);

        //then
        assertThat(expectedNumbers).isEqualTo(userInputNumbers);
    }

    @Test
    void should_return_empty_set_when_all_given_numbers_are_not_in_range() {
        //given
        Set<Integer> expectedNumbers = Collections.emptySet();
        String userTextInput = "0 -1 100 201 -12 157";
        Scanner userInputScanner = getScannerFromString(userTextInput);

        //when
        final Set<Integer> userInputNumbers = numberInputReceiver.getNumbersFromUser(userInputScanner);

        //then
        assertThat(expectedNumbers).isEqualTo(userInputNumbers);
    }

    @Test
    void should_return_set_with_six_numbers_when_two_given_numbers_were_not_in_range() {
        //given
        Set<Integer> expectedNumbers = Set.of(10, 20, 30, 40, 50, 60);
        String userTextInput = "10 120 20 30 -10 40 50 60";
        Scanner userInputScanner = getScannerFromString(userTextInput);

        //when
        final Set<Integer> userInputNumbers = numberInputReceiver.getNumbersFromUser(userInputScanner);

        //then
        assertThat(expectedNumbers).isEqualTo(userInputNumbers);
    }

    private Scanner getScannerFromString(String text) {
        return new Scanner(text);
    }
}