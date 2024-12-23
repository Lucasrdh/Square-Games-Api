package com.squaresgames.Square.games.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class GameCreationParamsDTO {
    @NotNull(message = "Game ne peut pas être null.")
    @NotBlank(message = "Game ne peut pas être vide.")
    private String gameType;

    private  int boardSize;
    private int playerCount;

    public GameCreationParamsDTO(String gameType, int boardSize, int playerCount) {
        this.gameType = gameType;
        this.boardSize = boardSize;
        this.playerCount = playerCount;
    }
    public String getGameType() {
        return gameType;
    }
    public int getBoardSize() {
        return boardSize;
    }
    public int getPlayerCount() {
        return playerCount;
    }
}
