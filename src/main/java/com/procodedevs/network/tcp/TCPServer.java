package com.procodedevs.network.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import com.procodedevs.network.thread.NetworkThread;

public class TCPServer {

	public static void main(String args[])throws Exception{  
		
		
		ServerSocket ss=new ServerSocket(3333);  
		Socket s=ss.accept();  
		
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  

		NetworkThread threadObject = new NetworkThread(din);
		new Thread(threadObject).start();
		
		String str="",str2="";  
		while(!str.equals("stop")){  
			str2=br.readLine();  //Keyboard reading
			dout.writeUTF(str2);  
			dout.flush();  
		} 
		din.close();  
		s.close();  
		ss.close();  
	}

}
