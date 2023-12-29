package com.gmail.sizeeq;

import com.gmail.sizeeq.input.NumberInputReceiver;
import com.gmail.sizeeq.logic.HitNumberCalculator;
import com.gmail.sizeeq.messages.Messages;
import com.gmail.sizeeq.numbergenerator.WinningNumberGenerator;
import com.gmail.sizeeq.result.GameResult;
import com.gmail.sizeeq.result.ResultMessage;

import java.util.Scanner;
import java.util.Set;

public class LottoGameFacade implements Game {

    private final Scanner scanner;
    private final NumberInputReceiver numberInputReceiver;
    private final WinningNumberGenerator winningNumberGenerator;
    private final HitNumberCalculator hitNumberCalculator;

    public LottoGameFacade(Scanner scanner, NumberInputReceiver numberInputReceiver, WinningNumberGenerator winningNumberGenerator, HitNumberCalculator hitNumberCalculator) {
        this.scanner = scanner;
        this.numberInputReceiver = numberInputReceiver;
        this.winningNumberGenerator = winningNumberGenerator;
        this.hitNumberCalculator = hitNumberCalculator;
    }

    @Override
    public GameResult startGame() {
        System.out.println(Messages.START_GAME);
        final ResultMessage gameResult = getHitNumbers();
        return getGameResult(gameResult);
    }

    private ResultMessage getHitNumbers() {
        final Set<Integer> userInput = numberInputReceiver.getNumbersFromUser(scanner);
        final Set<Integer> winningNumbers = winningNumberGenerator.generateWinningNumbers();
        return hitNumberCalculator.getHitNumbers(winningNumbers, userInput);
    }

    private GameResult getGameResult(ResultMessage resultMessage) {
        final GameResult gameResult = new GameResult(this, resultMessage);
        System.out.println(resultMessage.getGameResultMessage());
        return gameResult;
    }
}
