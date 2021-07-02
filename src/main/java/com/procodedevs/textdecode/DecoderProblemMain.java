package com.procodedevs.textdecode;


public class DecoderProblemMain {

	
	public static void main(String[] args) {
		String message = "26#68802#2244408884442225599904433555#555666";
		
		String asciiMessage = "97-109-109-117";
		
		Decoder keyPadDecoder = new KeypadDecoder(message);
		Decoder asciiDecoder = new AsciiDecoder(asciiMessage);
		
		keyPadDecoder.decode();
		
		
		System.out.println(keyPadDecoder);
		System.out.println(asciiDecoder.decode());
	}
	
}
