package com.squaresgames.Square.games.service;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.Token;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface GameService {
    public List<Game> getAllGames();


//    Token getTokenWithName(Game game, String tokenName);

    String createGame(@RequestBody GameCreationParams params);

    Game updateGame(Game game);

    public ResponseEntity<String> deleteGame(@PathVariable String gameId);
}
