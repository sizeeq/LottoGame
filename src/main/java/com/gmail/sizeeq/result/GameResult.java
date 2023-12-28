package com.gmail.sizeeq.result;

import com.gmail.sizeeq.Game;

public class GameResult {
    private final Game game;
    private final GameResultMessage gameResultMessage;

    public GameResult(Game game, GameResultMessage gameResultMessage) {
        this.game = game;
        this.gameResultMessage = gameResultMessage;
    }
}
