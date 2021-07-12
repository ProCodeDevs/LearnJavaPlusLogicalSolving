package com.procodedevs.network.thread;

import java.io.DataInputStream;
import java.io.IOException;

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
				System.out.println("User says: "+str2);  
			} catch (IOException e) {
				e.printStackTrace();
			}  
		}
	}
	
	
}
