package com.squaresgames.Square.games.plugins;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGame;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.OptionalInt;

@Component
public class TicTacToePlugin implements GamePlugin {
    private final TicTacToeGameFactory gameFactory = new TicTacToeGameFactory();
    @Autowired
    private MessageSource messageSource;

    public TicTacToePlugin() {
    }

    @Value("${game.tictactoe.default-player-count}")
    private int defaultPlayerCount;

    @Value("${game.tictactoe.default-board-size}")
    private int defaultBoardSize;

    @Override
    public String getName(Locale locale) {
        return MessageSource.getMessage("messages.tictactoe.title", null, locale);
    }

    @Override
    public Game createGame(OptionalInt playerCount, OptionalInt boardSize) {
        if (boardSize.isPresent() && playerCount.isPresent()) {
            return gameFactory.createGame(playerCount.getAsInt(), boardSize.getAsInt());
        }
        return gameFactory.createGame(defaultPlayerCount, defaultBoardSize);
    }


}

