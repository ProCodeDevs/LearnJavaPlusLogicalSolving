package com.game.samplegame;

import java.util.ArrayList;
import java.util.List;

public class GameStatus {

    private boolean gameStarted;
    private boolean playerOneTurn;
    private Long gameId;
    
   
    private boolean playerOneConnected;
    private boolean playerTwoConnected;

    private List<Integer> playerOneMoves;
    private List<Integer> playerTwoMoves;
       
    public GameStatus(){
        playerOneMoves = new ArrayList<>();
        playerTwoMoves = new ArrayList<>();
    }
    
    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }
    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }
    public boolean isPlayerOneTurn() {
        return playerOneTurn;
    }
    public void setPlayerOneTurn(boolean playerOneTurn) {
        this.playerOneTurn = playerOneTurn;
    }
    public boolean isPlayerOneConnected() {
        return playerOneConnected;
    }
    public void setPlayerOneConnected(boolean playerOneConnected) {
        this.playerOneConnected = playerOneConnected;
    }
    public boolean isPlayerTwoConnected() {
        return playerTwoConnected;
    }
    public void setPlayerTwoConnected(boolean playerTwoConnected) {
        this.playerTwoConnected = playerTwoConnected;
    }
    public List<Integer> getPlayerOneMoves() {
        return playerOneMoves;
    }
    public void setPlayerOneMoves(List<Integer> playerOneMoves) {
        this.playerOneMoves = playerOneMoves;
    }
    public List<Integer> getPlayerTwoMoves() {
        return playerTwoMoves;
    }
    public void setPlayerTwoMoves(List<Integer> playerTwoMoves) {
        this.playerTwoMoves = playerTwoMoves;
    }
}
