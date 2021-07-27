package com.game.samplegame;

import java.util.ArrayList;
import java.util.List;

public class GameStatus {

  private boolean gameStarted;
  private boolean playerOneTurn;
  private boolean playerTwoTurn;
  private String roomId;
  private String serverComment;

  private boolean playerOneConnected;
  private boolean playerTwoConnected;

  private List<Integer> playerOneMoves;
  private List<Integer> playerTwoMoves;
  private List<Integer> roundStatus;

  public String getServerComment() {
    return this.serverComment;
  }

  public void setServerComment(String serverComment) {
    this.serverComment = serverComment;
  }

  public GameStatus() {
    playerOneMoves = new ArrayList<>();
    playerTwoMoves = new ArrayList<>();
    roundStatus = new ArrayList<>();
  }

  public String getRoomId() {
    return roomId;
  }

  public void setRoomId(String roomId) {
    this.roomId = roomId;
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

  public void setPlayerTwoTurn(boolean playerTwoTurn) {
    this.playerTwoTurn = playerTwoTurn;
  }

  public boolean isPlayerTwoTurn() {
    return playerTwoTurn;
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

  public List<Integer> getRoundStatus() {
    return roundStatus;
  }

  public void setRoundStatus(List<Integer> roundStatus) {
    this.roundStatus = roundStatus;
  }
}
