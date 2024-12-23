package com.squaresgames.Square.games.service;
import com.squaresgames.Square.games.modele.plugin.GamePlugin;
import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class GameServiceImpl implements GameService {

    private final Map<String, GamePlugin> gamePlugins = new HashMap<String, GamePlugin>();

    public GameServiceImpl(List<GamePlugin> plugins) {
        for (GamePlugin plugin : plugins) {
            gamePlugins.put(plugin.getGameIdentifier(), plugin);
        }
    }

    @Override
    public Game createGame(String gameIdentifier) {
        GamePlugin plugin = gamePlugins.get(gameIdentifier);
        if (plugin == null) {
            throw new IllegalArgumentException("Unknown game: " + gameIdentifier);
        }
        return plugin.createGame(OptionalInt.empty(), OptionalInt.empty());
    }
}