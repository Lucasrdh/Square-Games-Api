package com.squaresgames.Square.games.controller;

import ch.qos.logback.core.model.Model;
import com.squaresgames.Square.games.modele.GameCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class GameCatalogController {
    private final GameCatalog gameCatalog;

    @Autowired
    public GameCatalogController(GameCatalog gameCatalog) {
        this.gameCatalog = gameCatalog;
    }

    @GetMapping("/gamesCatalog")
    public Collection<String> getGameIdentifiers() {
return gameCatalog.getGameIdentifiers();
    }
}
