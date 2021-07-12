package com.procodedevs.bot;

import java.awt.Robot;

public class SampleBot {


	public static void myBot(String command) throws Exception{
		Robot robot = new Robot();   
		for(int i=0;i<command.length();i++) {
			int code = command.charAt(i);
			robot.keyPress(code);
			Thread.sleep(500);
		}
	}   

}
