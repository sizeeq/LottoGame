package com.gmail.sizeeq.result;

import com.gmail.sizeeq.messages.Messages;

import java.util.Set;

public class LottoGameResult implements GameResultMessage {

    private final Set<Integer> hitNumbers;
    private final Set<Integer> userInput;
    private final Set<Integer> winningNumbers;
    public LottoGameResult(Set<Integer> hitNumbers, Set<Integer> userInput, Set<Integer> winningNumbers) {
        this.hitNumbers = hitNumbers;
        this.userInput = userInput;
        this.winningNumbers = winningNumbers;
    }

    @Override
    public String getGameResultMessage() {
        String winResultMessage = String.format(Messages.WINNING_RESULT_MESSAGE, hitNumbers.size(), winningNumbers, userInput);
        String loseResultMessage = String.format(Messages.LOSING_RESULT_MESSAGE, hitNumbers.size(), winningNumbers, userInput);
        return hitNumbers.size() >= 3 ? winResultMessage : loseResultMessage;
    }
}
