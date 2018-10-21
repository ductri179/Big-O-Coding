package com.oscartran.midterm;

import java.util.Scanner;

class Prob_B {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			int[] arr = new int[500];
			int n = sc.nextInt();
			String str = sc.next();
			str = str.toLowerCase();
			for (int i = 0; i < n; i++) {
				char c = str.charAt(i);
				arr[c]++;
			}

			for (char i = 'a'; i <= 'z'; i++) {
				if (arr[i] == 0) {
					System.out.println("NO");
					return;
				}
			}
			System.out.println("YES");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
