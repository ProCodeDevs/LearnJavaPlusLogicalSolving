package com.game.samplegame;

import java.io.File;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.commons.io.FileUtils;

public class FileHandler {

  static String folderName = "mydatabase/";
  static Gson gson = new GsonBuilder().setPrettyPrinting().create();

  public static void write(String roomId, GameStatus status) throws IOException {

    FileUtils.writeStringToFile(getRoomFile(roomId), gson.toJson(status), "UTF-8");
  }

  public static boolean isFileExists(String roomId) {
    return getRoomFile(roomId).exists();
  }

  public static GameStatus retrive(String roomId) throws IOException {
    File roomFile = getRoomFile(roomId);
    String fileContent = FileUtils.readFileToString(roomFile, "UTF-8");
    GameStatus status = gson.fromJson(fileContent, GameStatus.class);
    return status;
  }

  public static File getRoomFile(String roomId) {
    return new File(folderName + File.separator + roomId + ".txt");
  }
}
