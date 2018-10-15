package com.oscartran.spoj;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

class TRVCOST {

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
		int n = graph.length;
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
			for (int i = 0; i < graph[u].size(); i++) {
				Node neighbor = graph[u].get(i);
				if (w + neighbor.dist < dist[neighbor.id]) {
					dist[neighbor.id] = w + neighbor.dist;
					pq.add(new Node(neighbor.id, dist[neighbor.id]));
					path[neighbor.id] = u;
				}
			}
		}
	}

	private static int[] dist;
	private static int[] path;
	private static ArrayList<Node>[] graph;

	public static void main(String[] args) {
		try {
			Reader sc = new Reader();
			int n = sc.nextInt();
			graph = new ArrayList[501];
			
			for (int i = 0; i < 501; i++) {
				graph[i] = new ArrayList();
			}
			
			for (int i = 0; i < n; i ++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				graph[a].add(new Node(b, c));
				graph[b].add(new Node(a, c));
			}
			
			int u = sc.nextInt();
			int q = sc.nextInt();
			
			
			Dijkstra(u);
			
			for (int i = 0; i < q; i++) {
				int res = dist[sc.nextInt()];
				System.out.println(res == Integer.MAX_VALUE ? "NO PATH" : res);
			}
		} catch (Exception e) {
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
