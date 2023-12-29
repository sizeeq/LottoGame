package com.gmail.sizeeq;

import com.gmail.sizeeq.input.NumberInputReceiver;
import com.gmail.sizeeq.logic.HitNumberCalculator;
import com.gmail.sizeeq.numbergenerator.WinningNumberGenerator;
import com.gmail.sizeeq.result.GameResult;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LottoGameFacadeTest {

    private static final Scanner scanner = new Scanner(System.in);
    private static final NumberInputReceiver numberInputReceiverMock = mock(NumberInputReceiver.class);
    private static final WinningNumberGenerator winningNumberGeneratorMock = mock(WinningNumberGenerator.class);
    private static final HitNumberCalculator hitNumberCalculator = new HitNumberCalculator();

    private static Stream<Arguments> testData() {
        final Arguments hit2 = Arguments.of(Collections.unmodifiableSet(new LinkedHashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))), Collections.unmodifiableSet(new LinkedHashSet<>(Arrays.asList(1, 20, 30, 4, 50, 60))), "You've lost! 2 numbers hit! Winning numbers [1, 2, 3, 4, 5, 6], your numbers [1, 20, 30, 4, 50, 60]");
        final Arguments hit6 = Arguments.of(Collections.unmodifiableSet(new LinkedHashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))), Collections.unmodifiableSet(new LinkedHashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))), "You've won! 6 numbers hit! Winning numbers [1, 2, 3, 4, 5, 6], your numbers [1, 2, 3, 4, 5, 6]");
        return Stream.of(hit2, hit6);
    }

    private void mockNumberProvider(Set<Integer> inputNumbers, Set<Integer> winningNumber) {
        when(numberInputReceiverMock.getNumbersFromUser(scanner)).thenReturn(inputNumbers);
        when(winningNumberGeneratorMock.generateWinningNumbers()).thenReturn(winningNumber);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void should_return_win_or_lose_message_depending_on_game_result(Set<Integer> winningNumbers, Set<Integer> inputNumbers, String resultMessage) {
        //given
        mockNumberProvider(inputNumbers, winningNumbers);
        Game lotto = new LottoGameFacade(scanner, numberInputReceiverMock, winningNumberGeneratorMock, hitNumberCalculator);
        //when
        final GameResult gameResult = lotto.startGame();
        //then
        assertEquals(resultMessage, gameResult.resultMessage().getGameResultMessage());
    }
}