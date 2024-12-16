package com.squaresgames.Square.games.controller;

import com.squaresgames.Square.games.modele.GameCatalog;
import com.squaresgames.Square.games.service.GameCreationParams;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class GameController {
    @Autowired
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
}
