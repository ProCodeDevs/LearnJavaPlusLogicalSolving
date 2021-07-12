package com.procodedevs.textdecode;

import java.util.Scanner;

public class CryptoGraphy {

	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter String");
		String message = scanner.next();
		
		System.out.println("Enter Key");
		int key = scanner.nextInt();
		int defaultKey = 2;
		String firstEncoding = encode(message, key);
		String finalResult = encode(key+"-"+firstEncoding, defaultKey);
		System.out.println(finalResult);
		
		//decoding first time..
		System.out.println(decode(finalResult, defaultKey));
	}
	
	public static String encode(String message,int key) {
		String encoded = "";
		for(int i=0;i<message.length();i++) {
			encoded += ( ((char) (message.charAt(i) + key)));
		}
		return encoded;
	}
	
	public static String decode(String encodedText,int key) {
		String decoded = "";
		for(int i=0;i<encodedText.length();i++) {
			decoded += ( ((char) (encodedText.charAt(i) - key)));
		}
		return decoded;
	}
	
}
