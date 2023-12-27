package com.gmail.sizeeq.messages;

import com.gmail.sizeeq.config.Config;

public class Messages {

    public static final String LOTTO_GAME_HAS_STARTED = "Lotto game has started!";
    public static final String ENTER_NUMBERS = String.format("Please enter %d numbers!", Config.NUMBERS_FROM_USER);
    public static final String ENTER_NUMBER = String.format("Please enter number from %d-%d!", Config.LOWER_BOUND, Config.UPPER_BOUND);
    public static final String NUMBER_NOT_IN_RANGE = String.format("The number you've entered is not in range %d-%d", Config.LOWER_BOUND, Config.UPPER_BOUND);
}
