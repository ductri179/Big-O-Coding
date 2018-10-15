package com.oscartran.uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Prob_10986_SendingEmail {

	static class Node implements Comparable<Node> {
		public Integer id;
		public Integer dist;

		public Node(Integer id, Integer dist) {
			this.id = id;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node other) {
			return this.dist.compareTo(other.dist);
		}
	}

	public static void Dijkstra(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		int n = graph.size();
		dist = new int[n];
		path = new int[n];
		for (int i = 0; i < n; i++) {
			dist[i] = Integer.MAX_VALUE;
			path[i] = -1;
		}
		pq.add(new Node(s, 0));
		dist[s] = 0;
		
		while (!pq.isEmpty()) {
			Node top = pq.poll();
			int u = top.id;
			int w = top.dist;
			for (int i = 0; i < graph.get(u).size(); i++) {
				Node neighbor = graph.get(u).get(i);
				if (w + neighbor.dist< dist[neighbor.id]) {
					dist[neighbor.id] = w + neighbor.dist;
					pq.add(new Node(neighbor.id, dist[neighbor.id]));
					path[neighbor.id] = u;
				}
			}
		}
	}
	
	private static int[] dist;
	private static int[] path;
	private static ArrayList<ArrayList<Node>> graph;
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		
		int N = sc.nextInt();
		
		for (int k = 1; k <= N; k++) {
			int n, m , S, T;
			
			n = sc.nextInt();
			m = sc.nextInt();
			S = sc.nextInt();
			T = sc.nextInt();
			
			graph = new ArrayList<ArrayList<Node>>();
			for (int i = 0; i < n; i++) {
				graph.add(new ArrayList<Node>());
			}
			
			for (int i = 0; i < m; i++) {
				int a, b, w;
				a = sc.nextInt();
				b = sc.nextInt();
				w = sc.nextInt();
				
				graph.get(a).add(new Node(b, w));
				graph.get(b).add(new Node(a, w));
			}
			
			Dijkstra(S);
			System.out.println("Case #" + k +": " + ((dist[T] == Integer.MAX_VALUE) ? "unreachable" : dist[T]));
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
