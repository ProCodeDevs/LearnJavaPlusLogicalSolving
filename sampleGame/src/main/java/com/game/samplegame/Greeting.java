package com.game.samplegame;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Greeting {

  public final static int STONE = 1;
  public final static int PAPER = 2;
  public final static int SCISSOR = 3;
  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @GetMapping("/greeting")
  public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    return "hello " + name;
  }

  @GetMapping("/Createroom")
  public GameStatus createRoom() throws IOException {
    UUID uuid = UUID.randomUUID();
    GameStatus newStatus = new GameStatus();
    newStatus.setRoomId(uuid.toString());
    FileHandler.write(newStatus.getRoomId(), newStatus);
    return newStatus;
  }

  @GetMapping("/join")
  public GameStatus joinPlayer(@RequestParam(value = "roomId") String roomId) throws IOException {
    if (FileHandler.isFileExists(roomId)) {
      GameStatus status = FileHandler.retrive(roomId);
      if (status.isPlayerOneConnected() && status.isPlayerTwoConnected()) {
        status.setServerComment("ROOM_FULL");
      } else if (!status.isPlayerOneConnected()) {
        status.setPlayerOneConnected(true);
        status.setServerComment("1");
      } else {
        status.setPlayerTwoConnected(true);
        status.setServerComment("2");
        status.setPlayerOneTurn(true);
        status.setGameStarted(true);
      }
      FileHandler.write(status.getRoomId(), status);
      return status;
    } else {
      return null;
    }
  }

  @GetMapping("/status")
  public GameStatus status(@RequestParam(value = "roomId") String roomId) throws IOException {
    if (FileHandler.isFileExists(roomId)) {
      GameStatus status = FileHandler.retrive(roomId);
      return status;
    } else {
      return null;
    }
  }

  @GetMapping("/move")
  public GameStatus move(@RequestParam(value = "roomId") String roomId,
      @RequestParam(value = "playerId") Integer playerNo, @RequestParam(value = "moveId") Integer moveId)
      throws IOException {
    if (FileHandler.isFileExists(roomId)) {
      GameStatus status = FileHandler.retrive(roomId);
      if (playerNo == 1) {
        status.getPlayerOneMoves().add(moveId);
        status.setPlayerOneTurn(false);
        status.setPlayerTwoTurn(true);
      } else {
        status.getPlayerTwoMoves().add(moveId);
        status.setPlayerTwoTurn(false);
        status.setPlayerOneTurn(true);
        updateGameRoundStatus(status);
      }
      FileHandler.write(status.getRoomId(), status);
      return status;
    } else {
      return null;
    }
  }

  private void updateGameRoundStatus(GameStatus status) {
    int index = status.getRoundStatus().size();
    int playerOneMove = status.getPlayerOneMoves().get(index);
    int playerTwoMove = status.getPlayerTwoMoves().get(index);
    int win = 0;
    if (playerOneMove == STONE && playerTwoMove == PAPER) {
      win = 2;
    } else if (playerOneMove == PAPER && playerTwoMove == STONE) {
      win = 1;
    } else if (playerOneMove == PAPER && playerTwoMove == SCISSOR) {
      win = 2;
    } else if (playerOneMove == SCISSOR && playerTwoMove == PAPER) {
      win = 1;
    } else if (playerOneMove == SCISSOR && playerTwoMove == STONE) {
      win = 2;
    } else if (playerOneMove == STONE && playerTwoMove == SCISSOR) {
      win = 1;
    }
    status.getRoundStatus().add(win);
  }

}
