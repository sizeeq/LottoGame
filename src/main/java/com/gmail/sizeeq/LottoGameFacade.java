package com.gmail.sizeeq;

import com.gmail.sizeeq.input.NumberReceiver;
import com.gmail.sizeeq.logic.HitNumberCalculator;
import com.gmail.sizeeq.messages.Messages;
import com.gmail.sizeeq.numbergenerator.WinningNumberGenerator;
import com.gmail.sizeeq.result.GameResult;
import com.gmail.sizeeq.result.GameResultMessage;

import java.util.Scanner;
import java.util.Set;

public class LottoGameFacade implements Game{

    private final Scanner scanner;
    private final NumberReceiver numberReceiver;
    private final WinningNumberGenerator winningNumberGenerator;
    private final HitNumberCalculator hitNumberCalculator;

    public LottoGameFacade(Scanner scanner, NumberReceiver numberReceiver, WinningNumberGenerator winningNumberGenerator, HitNumberCalculator hitNumberCalculator) {
        this.scanner = scanner;
        this.numberReceiver = numberReceiver;
        this.winningNumberGenerator = winningNumberGenerator;
        this.hitNumberCalculator = hitNumberCalculator;
    }

    @Override
    public GameResult startGame() {
        System.out.println(Messages.START_GAME);
        final GameResultMessage gameResult = getHitNumbers();
        return getGameResult(gameResult);
    }

    private GameResultMessage getHitNumbers() {
        final Set<Integer> userInput = numberReceiver.getNumbersFromUser(scanner);
        final Set<Integer> winningNumbers = winningNumberGenerator.generateWinningNumbers();
        return hitNumberCalculator.getHitNumbers(winningNumbers, userInput);
    }

    private GameResult getGameResult(GameResultMessage gameResultMessage) {
        final GameResult gameResult = new GameResult(this, gameResultMessage);
        System.out.println(gameResultMessage.getGameResultMessage());
        return gameResult;
    }
}
