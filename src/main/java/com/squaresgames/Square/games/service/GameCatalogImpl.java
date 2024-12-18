package com.squaresgames.Square.games.service;

import com.squaresgames.Square.games.modele.GameCatalog;
import com.squaresgames.Square.games.modele.GamePlugin;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGame;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameCatalogImpl implements GameCatalog {

    private final List<GamePlugin> gamePlugins;
    private final List<Game> games = new ArrayList<>();

    public GameCatalogImpl(List<GamePlugin> gamePlugins) {
        this.gamePlugins = gamePlugins;
    }

    @Override
    public Collection<String> getGameIdentifiers() {
        List<String> gameIdentifiers = new ArrayList<>();
        for (GamePlugin plugin : gamePlugins) {
            gameIdentifiers.add(plugin.getName(Locale.getDefault()));
        }
        return gameIdentifiers;
    }
    @Override
    public Collection<Game> getGames() {
        return Collections.unmodifiableCollection(games);
    }

    @Override
    public void addGame(Game game) {
        games.add(game);
    }

    @Override
    public boolean removeGame(String gameId) {
        return games.removeIf(game -> game.getId().toString().equals(gameId));
    }
}
