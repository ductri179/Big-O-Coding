package com.oscartran.midterm;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Prob_D {

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };

	static int[][] graph;
	static LinkedList<Point> q;
	static Point[][] path;
	static int[][] visited;
	static int R, C;

	public static void main(String[] args) {
		try {
			MyScanner sc = new MyScanner();

			R = sc.nextInt();
			C = sc.nextInt();

			while (R != 0 && C != 0) {
				int r = sc.nextInt();
				graph = new int[R][C];
				visited = new int[R][C];
				path = new Point[R][C];
				q = new LinkedList<Point>();
				
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						path[i][j] = new Point(-1, -1);
					}
				}

				for (int i = 0; i < r; i++) {
					int a, b, c;
					a = sc.nextInt();
					b = sc.nextInt();

					for (int j = 0; j < b; j++) {
						c = sc.nextInt();
						graph[a][c] = 1;
					}
				}
				Point s = new Point(sc.nextInt(), sc.nextInt());
				Point f = new Point(sc.nextInt(), sc.nextInt());
				bfs(s);
				System.out.println(printPath(s, f));
				R = sc.nextInt();
				C = sc.nextInt();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int printPath(Point s, Point f) {
		if (f == s) {
			return 0;
		}
		if (path[f.x][f.y].equals(new Point(-1, -1))) {
			return 0;
		}

		int res = 0;

		while (true) {
			f = path[f.x][f.y];
			res++;
			if (path[f.x][f.y].equals(new Point(-1, -1))) {
				break;
			}
		}

		return res;
	}

	private static void bfs(Point s) {
		q.add(s);
		visited[s.x][s.y] = 1;

		while (!q.isEmpty()) {
			Point t = q.remove();
			for (int i = 0; i < 4; i++) {
				int x = dx[i] + t.x;
				int y = dy[i] + t.y;
				Point curNode = new Point(x, y);
				if (x >= 0 && x < R && y >= 0 && y < C && graph[x][y] == 0) {
					if (visited[x][y] == 0) {
						visited[x][y] = 1;
						q.add(curNode);
						path[x][y] = t;
					}
				}
			}
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
