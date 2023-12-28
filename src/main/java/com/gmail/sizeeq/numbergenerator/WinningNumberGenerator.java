package com.gmail.sizeeq.numbergenerator;

import com.gmail.sizeeq.config.Config;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumberGenerator {

    public Set<Integer> generateWinningNumbers() {
        return new Random()
                .ints(Config.NUMBERS_FROM_USER, Config.LOWER_BOUND_FOR_GENERATOR, Config.UPPER_BOUND_FOR_GENERATOR)
                .boxed()
                .collect(Collectors.toSet());
    }
}
