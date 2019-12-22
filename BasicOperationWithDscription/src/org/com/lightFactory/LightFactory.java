package org.com.lightFactory;

public class LightFactory {
	
	//Object Creation Logic
	public static ISwitch getLight(String type) {
		if(type.equalsIgnoreCase("tubelight")) {
			return new TubeLight();
		}else if(type.equalsIgnoreCase("syskabulb")) {
			return new SyskaBulb();
		}else {
			System.out.println("No light found");
			return null;
		}
	}
}
