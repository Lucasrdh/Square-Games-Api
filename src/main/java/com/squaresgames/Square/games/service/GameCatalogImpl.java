package com.squaresgames.Square.games.service;

import com.squaresgames.Square.games.modele.GameCatalog;
import com.squaresgames.Square.games.modele.plugin.GamePlugin;
import fr.le_campus_numerique.square_games.engine.Game;
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
    public Collection<String> getGameIdentifiers(Locale locale) {
        List<String> gameIdentifiers = new ArrayList<>();
        for (GamePlugin plugin : gamePlugins) {
            gameIdentifiers.add(plugin.getName(locale));
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
