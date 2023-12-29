package com.gmail.sizeeq.logic;

import com.gmail.sizeeq.result.LottoResultMessage;
import com.gmail.sizeeq.result.ResultMessage;

import java.util.HashSet;
import java.util.Set;

public class HitNumberCalculator {

    public ResultMessage getHitNumbers(Set<Integer> userInput, Set<Integer> winningNumbers) {
        Set<Integer> hitNumbers = new HashSet<>(userInput);
        hitNumbers.retainAll(winningNumbers);
        return new LottoResultMessage(hitNumbers, winningNumbers, userInput);
    }
}
