package com.gmail.sizeeq.logic;

import com.gmail.sizeeq.result.GameResultMessage;
import com.gmail.sizeeq.result.LottoGameResult;

import java.util.HashSet;
import java.util.Set;

public class HitNumberCalculator {

    public GameResultMessage getHitNumbers(Set<Integer> userInput, Set<Integer> winningNumbers) {
        Set<Integer> hitNumbers = new HashSet<>(userInput);
        hitNumbers.retainAll(winningNumbers);
        return new LottoGameResult(hitNumbers, winningNumbers, userInput);
    }
}
