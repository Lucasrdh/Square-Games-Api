package com.squaresgames.Square.games.modele;

import fr.le_campus_numerique.square_games.engine.Game;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Locale;
import java.util.OptionalInt;

public interface GamePlugin {
    @NotNull String getGameIdentifier();
    @NotBlank
    String getName(Locale locale);
    @NotNull Game createGame(
            OptionalInt playerCount,
            OptionalInt boardSize
    );
}