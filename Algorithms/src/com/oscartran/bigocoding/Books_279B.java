package com.oscartran.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Books_279B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,t;
		n = sc.nextInt();
		t = sc.nextInt();
		
		List<Integer> a = new ArrayList<>();
		
		int total = 0;
		a.add(0);
		for (int i=0; i<n; i++) {
			int tmp = sc.nextInt();
			a.add(tmp);
			total+=tmp;
		}
		a.add(0);
		
		int total1 = 0;
		int res = 0;
		for (int i = 0; i < a.size()-1; i++) {
			total1 += a.get(i);
			int total2 =0;
			for (int j = a.size()-1; j > i; j--) {
				total2+= a.get(j);
				if (t >= total-total1-total2) {
					if (res < j-i-1) {
						res = j-i-1;
					}
				}
			}
		}
		System.out.println(res);
	}
}

