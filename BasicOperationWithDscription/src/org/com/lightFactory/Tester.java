package org.com.lightFactory;

import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String type = scan.next();
		
		//consumer logic OR Utilization logic
		ISwitch iswitch = LightFactory.getLight(type);
		
		if(iswitch != null) {
			iswitch.sOn();
			iswitch.sOof();
		}
		
		
	}
}
