package com.squaresgames.Square.games.service;

import com.squaresgames.Square.games.modele.GameCatalog;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameCatalog gameCatalog;
    private GameFactory gameFactory;
    private List<Game> games = new ArrayList<>();


    @Override
    public List<Game> getAllGames() {
        return games;
    }

    @Override
    public String createGame(@RequestBody GameCreationParams params) {
        this.gameFactory = gameCatalog.getGameFactory(params.getType());
        Game game = gameFactory.createGame(params.getPlayerCount(),params.getBoardSize());
        games.add(game);
        return game.getId().toString();
    }
//    @Override
//    private static Token getTokenWithName(Game game, String tokenName) {
//        return Stream.of(game.getRemainingTokens(), game.getRemovedTokens(), game.getBoard().values())
//                .flatMap(Collection::stream)
//                .filter(t -> t.getName().equals(tokenName))
//                .filter(t -> t.canMove())
//                .findFirst()
//                .orElse(null);
//    }
    @Override
    public Game updateGame(Game game) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteGame(@PathVariable String gameId) {
        boolean deleted = games.removeIf(game -> game.getId().toString().equals(gameId));
        if (deleted) {
            return ResponseEntity.ok("wow");
        }
        return ResponseEntity.status(404).body("y'a un probleme");
    }
}
