package com.gmail.sizeeq.numbersgenerator;

import com.gmail.sizeeq.config.Config;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumberGenerator {

    public Set<Integer> generateWinningNumbers() {
        return new Random()
                .ints(Config.NUMBERS_FROM_USER, Config.LOWER_BOUND, Config.UPPER_BOUND)
                .boxed()
                .collect(Collectors.toSet());
    }
}
