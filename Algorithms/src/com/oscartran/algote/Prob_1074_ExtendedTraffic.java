package com.oscartran.algote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Prob_1074_ExtendedTraffic {
	
	static class Edge {
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
		Scanner sc = new Scanner(System.in);
		int t;
		t = sc.nextInt();
		
		for (int i = 1; i <= t; i++) {
			n = sc.nextInt();
			ArrayList<Integer> busyness = new ArrayList<Integer>();
			busyness.add(0);
			for (int j = 0; j < n; j++) {
				busyness.add(sc.nextInt());
			}
			
			graph = new ArrayList<Edge>();
			
			m = sc.nextInt();
			
			for (int j = 0; j < m; j++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				graph.add(new Edge(a, b, busyness.get(b) - busyness.get(a)));
			}
			
			dist = new int[n+1];
			path = new int[n+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			Arrays.fill(path, -1);
			
			BellmanFord(1);
			
			
			int q = sc.nextInt();
			
			System.out.println("Case " + i + ":");
			for (int j = 1; j <= q; j++) {
				int d = sc.nextInt();
				if (dist[d] == Integer.MAX_VALUE || dist[d] < 3) 
					System.out.println("?");
				else 
					System.out.println(dist[d]);
			}
		}
	}

}
