package com.oscartran.midterm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Prob_E {

	public static void main(String[] args) {
		try {
			MyScanner sc = new MyScanner();
			int n = sc.nextInt();
			long sum = 0;
			ArrayList<Integer> arr = new ArrayList<Integer>();
			
			for (int i = 0; i < n; i++) {
				arr.add(sc.nextInt());
			}
			Collections.sort(arr);
			System.out.println(arr.get(n/2));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		public String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

		void close() {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
