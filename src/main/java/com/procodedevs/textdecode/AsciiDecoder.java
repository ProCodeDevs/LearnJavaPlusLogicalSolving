package com.procodedevs.textdecode;

public class AsciiDecoder extends Decoder{

	public AsciiDecoder(String message) {
		super(message);
	}

	@Override
	public String decode() {
		String[] splitted = message.split("-");
		for(String each: splitted) {
			result += (char)Integer.parseInt(each);
		}
		return result;
	}
	
}
