package com.oscartran;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class DFS {
	static ArrayList<Boolean> visited;
	static ArrayList<ArrayList<Integer>> graph;
	static ArrayList<Integer> path;
	static Stack<Integer> stack;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v, e, s;
		
		v = sc.nextInt();
		e = sc.nextInt();
		graph = new ArrayList<ArrayList<Integer>>();
		path = new ArrayList<Integer>();
		visited = new ArrayList<Boolean>();
		stack = new Stack<Integer>();
		
		for (int i= 0;i < v; i++) {
			graph.add(new ArrayList<Integer>());
			visited.add(false);
			path.add(-1);
		}
		
		for (int i = 0; i < e; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		
		s = sc.nextInt();
		sc.close();
		
		dfs(s);
		printPath(0, 4);
	}
	
	private static void printPath(int s, int f) {
		System.out.println("==========");
		if (f == s) {
			System.out.println(f);
			return;
		}
		if (path.get(f) == -1) {
			System.out.println("No path");
			return;
		}
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		res.add(f);
		while (true) {
			res.add(path.get(f));
			f = path.get(f);
			if (path.get(f) == -1) {
				break;
			}
		}
		
		for (int i = res.size()-1; i >= 0; i--) {
			System.out.print(res.get(i) + " ");
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
}
