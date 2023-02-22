package com.char_encoder.encoder;

public class Encoder {

	String ref = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";
	String offset = "/";

	public String encode(String plainText) {

		String output = offset;

		for (int i = 0; i < plainText.length(); i++) {
			if (ref.indexOf(plainText.charAt(i)) != -1) {
				int index = ref.indexOf(plainText.charAt(i));
				int offIndex = ref.indexOf(offset.charAt(0));
				index -= offIndex;
				if (index < 0) {
					index = ref.length() + index;
				}
//				System.out.println(index);
				output += ref.charAt(index);
			} else {
				output += plainText.charAt(i);
			}

		}

		return output;
	}

	public String decode(String encodedText) {
		int offIndex = ref.indexOf(encodedText.charAt(0));
		String output = "";
		if (offIndex != -1) {
			for (int i = 1; i < encodedText.length(); i++) {

				int index = ref.indexOf(encodedText.charAt(i));

//				System.out.println("orig:" + index + " offindex:" + offIndex);
//				System.out.println(encodedText.charAt(i));

				if (index >= 0) {
					index += offIndex;

					if (index > 43) {
						index = index - ref.length();
					}
//					System.out.println(ref.charAt(index));
//					System.out.println(index);
					output += ref.charAt(index);
				} else {
					output += encodedText.charAt(i);
				}
			}

		} else {
			return encodedText;
		}

		return output;
	}
}
