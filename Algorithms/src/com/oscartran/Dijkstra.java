package com.oscartran;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Dijkstra {

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
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int v = sc.nextInt();
		graph = new ArrayList<ArrayList<Node>>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < v; i++) {
			graph.get(sc.nextInt()).add(new Node(sc.nextInt(), sc.nextInt()));
		}
		
		Dijkstra(1);
	}

}
