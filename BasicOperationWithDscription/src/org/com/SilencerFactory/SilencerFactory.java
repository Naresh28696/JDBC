package org.com.SilencerFactory;

public class SilencerFactory {
	//Object Creation Logic
	public static IntfcSelfstart getSilencer(String type) {
		if(type.equalsIgnoreCase("highsound")) {
			return new HighSoundedSilencer();
		}else if(type.equalsIgnoreCase("lowsound")) {
			return new LowSoundedSilencer();
		}else {
			System.out.println("Silencer Not Found");
			return null;
		}
	}
}
