package com.oscartran;

import java.util.ArrayList;

class Bellman_Ford {

	class Edge {
		public int source;
		public int target;
		public int weight;
		public Edge(int source, int target, int weight) {
			this.source = source;
			this.target = target;
			this.weight = weight;
		}
	}
	
	public static boolean BellmanFord(int s) {
		int u, v, w;
		dist[s] = 0;
		for (int i = 1; i <= n - 1; i++) {
			for (int j = 0; j < m; j++) {
				u = graph.get(j).source;
				v = graph.get(j).target;
				w = graph.get(j).weight;
				if (dist[u] != Integer.MAX_VALUE && (dist[u] + w < dist[v])) {
					dist[v] = dist[u] + w;
					path[v] = u;
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			u = graph.get(i).source;
			v = graph.get(i).target;
			w = graph.get(i).weight;
			if (dist[u] != Integer.MAX_VALUE && (dist[u] + w < dist[v])) {
				return false;
			}
		}
		
		return true;
	}
	
	static int n, m;
	static int[] dist, path;
	static ArrayList<Edge> graph;
	
	public static void main(String[] args) {
		
	}

}
