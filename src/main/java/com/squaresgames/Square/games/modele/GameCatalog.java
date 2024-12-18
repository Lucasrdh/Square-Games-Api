package com.squaresgames.Square.games.modele;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;

import java.util.Collection;

public interface GameCatalog {
    Collection<String> getGameIdentifiers();

    Collection<Game> getGames();

    void addGame(Game game);

    boolean removeGame(String gameID);

}
