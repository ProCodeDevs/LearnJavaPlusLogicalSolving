package com.game.samplegame;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileHandler {
    
    static String file = "D://mydatabase//";

    public static void write(String roomId,String data) throws IOException{
        File database = new File(file+roomId+".txt");
        FileUtils.writeStringToFile(database, data, "UTF-8");
    }
}
