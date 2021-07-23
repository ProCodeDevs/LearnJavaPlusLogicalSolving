package com.game.samplegame;

import java.io.File;
import java.io.IOException;
import java.util.Random;
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

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return "hello " +name;
	}
    @GetMapping("/Createroom")
	public String createRoom() throws IOException {
        Random random=new Random();
		
		GameStatus newStatus = new GameStatus();
		newStatus.setGameId(random.nextLong());
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(newStatus);
		FileHandler.write(newStatus.getGameId()+"", json);
		return json;
	}

}
