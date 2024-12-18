package com.squaresgames.Square.games.service;

import com.squaresgames.Square.games.modele.GameCatalog;
import com.squaresgames.Square.games.modele.GamePlugin;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;
import java.util.stream.Stream;


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