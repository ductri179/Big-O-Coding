package com.oscartran.codeforces;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;


public class D_733 {
	
	static int MAX = 55;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	static int m, n, k;
	
	static int[][] visited = new int[MAX][MAX];
	static ArrayList<StringBuilder> maze = new ArrayList<>();
	static ArrayList<ArrayList<Point>> lakes = new ArrayList<ArrayList<Point>>();

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		m = sc.nextInt();
		n = sc.nextInt();
		k = sc.nextInt();
		
		String temp;
		for (int i = 0; i < m; i++) {
			temp = sc.nextLine();
			maze.add(new StringBuilder(temp));
			for (int j = 0; j < n; j++ ) {
				if (temp.charAt(j) == '.')
					visited[i][j] = 0; // water and not visited
				else
					visited[i][j] = -1; // land
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] == 0) {
					dfs(new Point(i, j));
				}
			}
		}
		
		LakeComparator c = new LakeComparator();
		Collections.sort(lakes, c);
		
		int dif = lakes.size() - k;
		int count = 0;
		for (int i = 0; i < dif; i++) {
			ArrayList<Point> curLake = lakes.get(i);
			count += curLake.size();
			for (int j = 0; j < curLake.size(); j++) {
				maze.get(curLake.get(j).x).setCharAt(curLake.get(j).y, '*');
				
			}
		}
		
		System.out.println(count);
		for (int i = 0; i < m; i++) {
			System.out.println(maze.get(i));
		}
	}

	static class LakeComparator implements Comparator<ArrayList<Point>> {

		@Override
		public int compare(ArrayList<Point> o1, ArrayList<Point> o2) {
			return o1.size() - o2.size();
		}
		
	}
	
	static void dfs(Point s) {
		Stack<Point> stack = new Stack<Point>();
		stack.push(s);
		visited[s.x][s.y] = 1; // visited
		ArrayList<Point> lake = new ArrayList<Point>();
		boolean isLake = true;
		
		lake.add(s);
		if (s.x == 0 || s.y == 0 || s.x == m -1 || s.y == n - 1) {
			//cell is on the edge so not a lake
			isLake = false;
		}
		
		while (!stack.isEmpty()) {
			Point t = stack.pop();
			
			for (int i = 0; i < 4; i++) {
				int x = t.x + dx[i];
				int y = t.y + dy[i];
				Point curNode = new Point(x, y);
				if (x >= 0 && x < m && y >= 0 && y < n) {
					if (visited[x][y] == 0 && maze.get(x).charAt(y) == '.') {
						visited[x][y] = 1;
						stack.push(curNode);
						lake.add(curNode);
						if (x == 0 || y == 0 || x == m -1 || y == n - 1) {
							//cell is on the edge so not a lake
							isLake = false;
						}
					}
				}
			}
		}
		if (isLake) {
			lakes.add(lake);
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
