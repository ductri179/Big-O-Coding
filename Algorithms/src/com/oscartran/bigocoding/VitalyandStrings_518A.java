package com.oscartran.bigocoding;

import java.io.InputStreamReader;
import java.util.Scanner;

public class VitalyandStrings_518A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		String s = sc.nextLine();
		String t = sc.nextLine();
		sc.close();
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == t.charAt(i)) {
				continue;
			}
			
			if (t.charAt(i) == s.charAt(i) + 1) {
				if (i == s.length() - 1)
					continue;
				char newChar = (char)(s.charAt(i) + 1);
				if (newChar > 'z') {
					continue;
				}
				String ans = s.substring(0, i) + newChar + s.substring(i + 1, s.length());
				System.out.println(ans);
				return;
			}
			
			char newChar = (char)(s.charAt(i) + 1);
			if (newChar > 'z') {
				continue;
			}
			
			String ans = s.substring(0, i) + newChar + s.substring(i + 1, s.length());
			System.out.println(ans);
			return;
		}
		
		System.out.println("No such string");
	}
}
