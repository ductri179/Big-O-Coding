package com.oscartran.spoj;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * Idea: using dijkstra to find shortest path from the exit cell to every other cells. Note: because this 
 * graph is directed graph and the given graph is for the paths from every cell to the exit cell so 
 * when we get the input, we have to reverse the direction of every cell.
 * 
 * */

class MICEMAZE {

	static class Node implements Comparable<Node> {
		public Integer id;
		public Long dist;

		public Node(Integer id, Long dist) {
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
		dist = new long[n];
		path = new long[n];
		for (int i = 0; i < n; i++) {
			dist[i] = Integer.MAX_VALUE;
			path[i] = -1;
		}
		pq.add(new Node(s, 0l));
		dist[s] = 0;

		while (!pq.isEmpty()) {
			Node top = pq.poll();
			int u = top.id;
			long w = top.dist;
			for (int i = 0; i < graph.get(u).size(); i++) {
				Node neighbor = graph.get(u).get(i);
				if (w + neighbor.dist < dist[neighbor.id]) {
					dist[neighbor.id] = w + neighbor.dist;
					pq.add(new Node(neighbor.id, dist[neighbor.id]));
					path[neighbor.id] = u;
				}
			}
		}
	}

	private static long[] dist;
	private static long[] path;
	private static ArrayList<ArrayList<Node>> graph;

	public static void main(String[] args) {
		try {
			Reader sc = new Reader();
			int n, e, t, m;
			n = sc.nextInt();
			e = sc.nextInt();
			t = sc.nextInt();
			m = sc.nextInt();
			
			graph = new ArrayList<ArrayList<Node>>();
			
			for (int i = 0; i <= n; i++) 
				graph.add(new  ArrayList<Node>());
			
			for (int i = 0; i < m; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				long c = sc.nextLong();
				graph.get(b).add(new Node(a, c));
			}
			
			Dijkstra(e);
			
			int count = 0;
			for (int i = 1; i <= n; i++) {
				if (dist[i] <= t) {
					count++;
				}
			}
			
			System.out.println(count);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}

}
