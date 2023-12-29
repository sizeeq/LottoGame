package com.gmail.sizeeq.result;

import com.gmail.sizeeq.config.Config;
import com.gmail.sizeeq.messages.Messages;

import java.util.Set;

public class LottoResultMessage implements ResultMessage {

    private final Set<Integer> hitNumbers;
    private final Set<Integer> userInput;
    private final Set<Integer> winningNumbers;

    public LottoResultMessage(Set<Integer> hitNumbers, Set<Integer> userInput, Set<Integer> winningNumbers) {
        this.hitNumbers = hitNumbers;
        this.userInput = userInput;
        this.winningNumbers = winningNumbers;
    }

    @Override
    public String getGameResultMessage() {
        String winResultMessage = String.format(Messages.WINNING_RESULT_MESSAGE, hitNumbers.size(), winningNumbers, userInput);
        String loseResultMessage = String.format(Messages.LOSING_RESULT_MESSAGE, hitNumbers.size(), winningNumbers, userInput);
        return getWinOrLoseMessage(winResultMessage, loseResultMessage, hitNumbers.size());
    }

    private String getWinOrLoseMessage(String winResultMessage, String loseResultMessage, int numberHit) {
        return numberHit >= Config.NUMBERS_HIT_TO_WIN ? winResultMessage : loseResultMessage;
    }
}
