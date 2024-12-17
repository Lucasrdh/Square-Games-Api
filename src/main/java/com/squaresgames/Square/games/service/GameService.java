package com.squaresgames.Square.games.service;

import fr.le_campus_numerique.square_games.engine.Game;

public interface GameService {
Game getGame();
Game getGame(int id);
Game createGame();
Game updateGame(Game game);
void deleteGame(Game game);
}
