package com.squaresgames.Square.games.service;

import com.squaresgames.Square.games.modele.GameCatalog;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGame;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class GameCatalogImpl implements GameCatalog {
    private final TicTacToeGameFactory tictacToeGameFactory;
    private final TaquinGameFactory taquinGameFactory;
    private final ConnectFourGameFactory connectFourGameFactory;

    public GameCatalogImpl() {
        this.tictacToeGameFactory = new TicTacToeGameFactory();
        this.taquinGameFactory = new TaquinGameFactory();
        this.connectFourGameFactory = new ConnectFourGameFactory();
    }


    @Override
    public Collection<String> getGameIdentifiers() {
        Collection<String> gameIdentifiers = new ArrayList<>();
        gameIdentifiers.add(tictacToeGameFactory.getGameFactoryId());
        gameIdentifiers.add(taquinGameFactory.getGameFactoryId());
        gameIdentifiers.add(connectFourGameFactory.getGameFactoryId());
        return gameIdentifiers;
    }

    @Override
    public GameFactory getGameFactory(String gameIdentifier) {
        return switch (gameIdentifier) {
            case "tictactoe" -> tictacToeGameFactory;
            case "connectfour" -> connectFourGameFactory;
            case "taquin" -> taquinGameFactory;
            default -> null;
        };
    }
}
