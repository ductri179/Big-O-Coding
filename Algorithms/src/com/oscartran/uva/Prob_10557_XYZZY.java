package com.oscartran.uva;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Prob_10557_XYZZY {
	
	static class Edge {
		public int source;
		public int target;

		public Edge(int source, int target) {
			this.source = source;
			this.target = target;
		}
	}

	public static boolean BellmanFord(int s) {
		int u, v, w;
		dist[s] = 0;
		for (int i = 1; i <= n - 1; i++) {
			for (int j = 0; j < m; j++) {
				u = graph.get(j).source;
				v = graph.get(j).target;
				w = energy[v];
				if (dist[u] != Integer.MAX_VALUE && (dist[u] + w > dist[v])) {
					dist[v] = dist[u] + w;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			u = graph.get(i).source;
			v = graph.get(i).target;
			w = energy[v];
			if (dist[u] != Integer.MAX_VALUE && (dist[u] + w > dist[v])) {
				return false;
			}
		}

		return true;
	}

	static int n, m;
	static int[] dist, energy;
	static ArrayList<Edge> graph;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		while (n != -1) {
			dist = new int[n + 1];
			energy = new int[n + 1];
			Arrays.fill(dist, Integer.MIN_VALUE);
			graph = new ArrayList<Edge>();
			
			for (int i = 1; i <= n; i++) {
				int e, num_doorway;
				e = sc.nextInt();
				energy[i] = e;
				num_doorway = sc.nextInt();
				
				for (int j = 0; j < num_doorway; j++) {
					int t = sc.nextInt();
					graph.add(new Edge(i, t));
				}
			}
			m = graph.size();
			
			boolean cycle = BellmanFord(1);
			if (100 + dist[n] > 0 || !cycle) {
				System.out.println("winnable");
			} else {
				System.out.println("hopeless");
			}
			n = sc.nextInt();
		}
		sc.close();
	}

}
