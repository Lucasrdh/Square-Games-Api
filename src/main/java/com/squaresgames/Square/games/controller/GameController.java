package com.squaresgames.Square.games.controller;

import com.squaresgames.Square.games.service.GameCreationParams;
import com.squaresgames.Square.games.service.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class GameController {

    private final GameServiceImpl gameService;

    @Autowired
    public GameController(GameServiceImpl gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/games")
    public String createGame(@RequestBody GameCreationParams params) {
        return gameService.createGame(params);
    }

    @GetMapping("/games/all")
    public List<fr.le_campus_numerique.square_games.engine.Game> getAllGames() {
        return gameService.getAllGames();
    }

    @DeleteMapping("/games/{gameId}")
    public ResponseEntity<String> deleteGame(@PathVariable String gameId) {
        return gameService.deleteGame(gameId);
    }
}
