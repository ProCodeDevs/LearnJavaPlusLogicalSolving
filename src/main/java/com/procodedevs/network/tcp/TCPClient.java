package com.procodedevs.network.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import com.procodedevs.network.thread.NetworkThread;

public class TCPClient {

	public static void main(String args[])throws Exception{  
		Socket s=new Socket("localhost",3333);  
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
		
		NetworkThread threadObject = new NetworkThread(din);
		new Thread(threadObject).start();
		
		String str="",str2="";  
		while(!str.equals("stop")){  
			str=br.readLine();  
			dout.writeUTF(str);  
			dout.flush();  
		}  

		dout.close();  
		s.close();  
	}

}
