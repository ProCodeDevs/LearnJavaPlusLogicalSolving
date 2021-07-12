package com.procodedevs.bot;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class SampleBot {


	public static void myBot(String command) throws Exception{
		Robot robot = new Robot();   
		for(int i=0;i<command.length();i++) {
			int keyCode = KeyEvent.getExtendedKeyCodeForChar(command.charAt(i));
			robot.keyPress(keyCode);
			Thread.sleep(500);
		}
	}   

}
