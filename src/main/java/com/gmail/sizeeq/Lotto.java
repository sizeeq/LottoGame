package com.gmail.sizeeq;

import com.gmail.sizeeq.input.NumberReceiver;
import com.gmail.sizeeq.logic.HitNumberCalculator;
import com.gmail.sizeeq.numbergenerator.WinningNumberGenerator;

import java.util.Scanner;

public class Lotto {
    public static void main(String[] args) {
        final Game game = getLottoGame();
        game.startGame();
    }

    public static Game getLottoGame() {
        final Scanner scanner = new Scanner(System.in);
        final NumberReceiver numberReceiver = new NumberReceiver();
        final WinningNumberGenerator winningNumberGenerator = new WinningNumberGenerator();
        final HitNumberCalculator hitNumberCalculator = new HitNumberCalculator();
        return new LottoGameFacade(scanner, numberReceiver, winningNumberGenerator, hitNumberCalculator);
    }
}
