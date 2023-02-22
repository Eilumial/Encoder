package com.char_encoder;

import com.char_encoder.encoder.Encoder;

public class LaunchEncoder {

	public static void main(String[] args) {
		Encoder e = new Encoder();
		
		String input = "HELLO WORLD";
		
		String encoded = e.encode(input);
		System.out.println(encoded);
		
		String decoded = e.decode(encoded);
		System.out.println(decoded);

	}

}
