package com.squaresgames.Square.games.controller;

import com.squaresgames.Square.games.modele.GameCatalog;
import com.squaresgames.Square.games.service.GameCreationParams;
import com.squaresgames.Square.games.service.GameService;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class GameController {
    @Autowired
    private GameService gameService;
    private GameCatalog gameCatalog;
    private GameFactory gameFactory;
    private List<Game> games = new ArrayList<>();

    @PostMapping("/games")
    public String createGame(@RequestBody GameCreationParams params) {
        this.gameFactory = gameCatalog.getGameFactory(params.getType());
        Game game = gameFactory.createGame(params.getPlayerCount(),params.getBoardSize());
        games.add(game);
        return game.getId().toString();
    }
    @GetMapping("/games/all")
    public List<Game> getAllGames() {
        return games;
    }
    @DeleteMapping("/games/{gameId}")
    public ResponseEntity<String> deleteGame(@PathVariable String gameId) {
        boolean deleted = games.removeIf(game -> game.getId().toString().equals(gameId));
        if (deleted) {
            return ResponseEntity.ok("wow");
        }
        return ResponseEntity.status(404).body("y'a un probleme");
    }
}
