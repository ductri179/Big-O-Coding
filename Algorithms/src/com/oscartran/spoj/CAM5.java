package com.oscartran.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

class CAM5 {
	static ArrayList<Boolean> visited;
	static ArrayList<ArrayList<Integer>> graph;
	static ArrayList<Integer> path;
	static Stack<Integer> stack;

	public static void main(String[] args) {
		try {
			MyScanner sc = new MyScanner();
			int t = sc.nextInt();
			ArrayList<Integer> res = new ArrayList<Integer>();

			for (int i = 0; i < t; i++) {
				graph = new ArrayList<ArrayList<Integer>>();
				path = new ArrayList<Integer>();
				visited = new ArrayList<Boolean>();
				stack = new Stack<Integer>();
				int N, e;
				N = sc.nextInt();
				e = sc.nextInt();

				for (int j = 0; j < N; j++) {
					graph.add(new ArrayList<Integer>());
					visited.add(false);
					path.add(-1);
				}

				for (int j = 0; j < e; j++) {
					int x, y;
					x = sc.nextInt();
					y = sc.nextInt();
					graph.get(x).add(y);
					graph.get(y).add(x);
				}
				int count = 0;
				for (int j = 0; j < N; j++) {
					if (visited.get(j) == false) {
						count++;
						dfs(j);
					}
				}
				res.add(count);
			}
			sc.close();
			for (Integer i : res) {
				System.out.println(i);
			}
			return;
		} catch (Exception e) {
			return;
		}
	}

	private static void dfs(int s) {
		stack.push(s);
		visited.set(s, true);

		while (!stack.isEmpty()) {
			int t = stack.pop();
			for (int i = 0; i < graph.get(t).size(); i++) {
				int curNode = graph.get(t).get(i);
				if (!visited.get(curNode)) {
					visited.set(curNode, true);
					stack.push(curNode);
					path.set(curNode, t);
				}
			}
		}
	}

	public static class MyScanner {
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

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
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
