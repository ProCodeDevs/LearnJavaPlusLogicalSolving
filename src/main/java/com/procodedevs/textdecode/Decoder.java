package com.procodedevs.textdecode;

public class Decoder {

	protected String message;
	protected String result = "";
	
	public Decoder(String message) {
		this.message = message;
	}
	
	public String decode() {
		return message;	
	}
	
	@Override
	public String toString() {
		return result;
	}
}
