package com.procodedevs.network.thread;

import java.awt.Robot;
import java.io.DataInputStream;
import java.io.IOException;

import com.procodedevs.bot.SampleBot;

public class NetworkThread implements Runnable{

	private DataInputStream inputStream;

	public NetworkThread(DataInputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public void run() {
		while(true) {
			String str2;
			try {
				str2 = inputStream.readUTF();
				
				try {
					SampleBot.myBot(str2);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				System.out.println("User says: "+str2);  
			} catch (IOException e) {
				e.printStackTrace();
			}  
		}
	}
	
	
}
