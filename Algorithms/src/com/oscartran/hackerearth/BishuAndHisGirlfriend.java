package com.oscartran.hackerearth;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class BishuAndHisGirlfriend {
	
	static ArrayList<Boolean> visited;
	static ArrayList<Integer> path;
	static ArrayList<ArrayList<Integer>> graph;
	static Stack<Integer> stack;
	static ArrayList<Integer> dist;
	static ArrayList<Integer> g;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v, e;
		
		v = sc.nextInt();
		e = v - 1;
		
		g = new ArrayList<Integer>();
		path = new ArrayList<Integer>();
		visited = new ArrayList<Boolean>();
		dist = new ArrayList<Integer>();
		graph = new ArrayList<ArrayList<Integer>>();
		stack = new Stack<Integer>();
		
		for (int i = 0; i <= v; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < e; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		
		int Q = sc.nextInt();
		for (int i = 0; i < Q; i++) {
			g.add(sc.nextInt());
		}
		sc.close();
		
		
		
		for (int i = 0; i <= v; i++) {
			visited.add(false);
			path.add(-1);
			dist.add(-1);
		}
		
		int res = dfs(1);
		System.out.println(res);
		
	}

	private static int dfs(int s) {
		stack.push(s);
		dist.set(s, 0);
		visited.set(s, true);
		
		int min = Integer.MAX_VALUE;
		int gNode = Integer.MAX_VALUE;
		
		while (!stack.isEmpty()) {
			int t = stack.pop();
			for (int i = 0; i < graph.get(t).size(); i++) {
				int curNode = graph.get(t).get(i);
				if (!visited.get(curNode)) {
					//find the min distance
					dist.set(curNode, dist.get(t)+1);
					if (g.contains(curNode) && min >= dist.get(curNode)) {
						if (min > dist.get(curNode)) {
							gNode = curNode;
							min = dist.get(curNode);
						} else if (gNode > curNode) {
							gNode = curNode;
						}
					}
					
					visited.set(curNode, true);
					stack.push(curNode);
					path.set(curNode, t);
				}
			}
		}
		return gNode;
	}
}
