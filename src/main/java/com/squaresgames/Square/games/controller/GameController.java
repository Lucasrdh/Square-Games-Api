package com.squaresgames.Square.games.controller;

import com.squaresgames.Square.games.modele.GameCatalog;
import com.squaresgames.Square.games.service.GameCreationParams;
import com.squaresgames.Square.games.service.GameCreationParamsDTO;
import com.squaresgames.Square.games.service.GameService;
import com.squaresgames.Square.games.service.GameServiceImpl;
import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameCatalog gameCatalog;

    @Autowired
    private GameService gameService;

    @PostMapping("/create")
    public ResponseEntity<?> createGame(@RequestBody @Validated GameCreationParamsDTO params) {
        try {
            Game newGame = gameService.createGame(params.getGameType());
            gameCatalog.addGame(newGame);
            return ResponseEntity.status(HttpStatus.CREATED).body("Game created.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Unknown error : " + e.getMessage());
        }
    }

}