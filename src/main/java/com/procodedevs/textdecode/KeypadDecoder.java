package com.procodedevs.textdecode;

/**
 * 
 * Keypad Decoder Class does decoding a text message
 * @author Vignesh Rajasekar
 *
 */
public class KeypadDecoder extends Decoder {

	String keyPad[] = {" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	
	public KeypadDecoder(String message) {
		super(message);
	}


	/**
	 * Call this method to decode
	 * @param text
	 * @return decodedText
	 */
	public String decode() {
		for(int i=0;i<message.length();i++) {
			int times = getHowManyTimesPressed(i,message);
			char key = message.charAt(i);
			if(key == '#') {
				continue;
			}
			result += getCharacter(key, times);
			i += times - 1;
		}

		return result;
	}


	private char getCharacter(char key, int times) {
		return keyPad[key - 48].charAt(times-1);

	}

	private int getHowManyTimesPressed(int index, String text) {
		char toFind = text.charAt(index);
		int count = 0;
		for(int i=index;i<text.length();i++) {
			if(text.charAt(i) == toFind) {
				count++;
			}
			else {
				break;
			}
		}
		return count;
	}
	
}
