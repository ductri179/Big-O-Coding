package com.oscartran.midterm;

import java.util.Scanner;

class Prob_C {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			int k, w, n;
			k = sc.nextInt();
			n = sc.nextInt();
			w = sc.nextInt();
			
			long m = 0;
			for (int i = 1; i <= w; i++) {
				m = m + i;
			}
			if (m*k - n > 0) {
				System.out.println(m*k - n);
			}else {
				System.out.println(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
