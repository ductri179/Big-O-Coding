package com.oscartran.bigocoding;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BigSegment_242B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		int n = sc.nextInt();
		List<List<Integer>> s = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		
		for (int i = 0; i < n; i++) {
			//Find the min and max value
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (min > a) {
				min = a;
			}
			if (max < b) {
				max = b;
			}
			//Store segments into List
			List<Integer> segment = new ArrayList<>();
			segment.add(a);
			segment.add(b);
			s.add(segment);
		}
		
		for (int i = 0; i < s.size(); i++) {
			if (s.get(i).get(0) == min && s.get(i).get(1) == max) {
				System.out.println(i + 1);
				sc.close();
				return;
			}
		}
		System.out.println(-1);
		sc.close();
	}

}
