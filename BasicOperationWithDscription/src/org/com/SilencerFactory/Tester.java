package org.com.SilencerFactory;

import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String type = scan.next();
		
		// Consumer Logic OR `Utilization Logic.
		IntfcSelfstart button = SilencerFactory.getSilencer(type);
		
		if(button != null) {
			button.SilencerSound();
		}
	}
}
