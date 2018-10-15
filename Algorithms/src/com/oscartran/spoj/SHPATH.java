package com.oscartran.spoj;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class SHPATH {

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
	
	static class CityName implements Comparable<CityName> {

		public Integer id;
		public String name;
		
		public CityName(Integer id, String name) {
			this.id = id;
			this.name = name;
		}
		
		@Override
		public int compareTo(CityName o) {
			return this.name.compareTo(o.name);
		}
	}
	
	static int binarySearch(String name, ArrayList<CityName> list) {
		int l = 0, r = list.size()-1;
		while (l <= r) {
			int i = (r+l)/2;
			if (name.compareTo(list.get(i).name) > 0) {
				l = i + 1;
			} else if (name.compareTo(list.get(i).name) < 0) {
				r = i - 1;
			} else {
				return list.get(i).id;
			}
		}
		return -1;
	}

	public static void Dijkstra(int s, int f) {
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
			if (top.id == f) 
				break;
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

	private static int[] dist;
	private static int[] path;
	private static ArrayList<ArrayList<Node>> graph;

	public static void main(String[] args) {
		try {
			Reader sc = new Reader();
			int s = sc.nextInt();
			
			for (int i = 0; i < s; i++) {
				int n = sc.nextInt();
				
				ArrayList<CityName> names = new ArrayList<CityName>();
				graph = new ArrayList<ArrayList<Node>>();
				
				graph.add(new ArrayList<Node>());
				for (int j = 1; j <= n; j++) {
					ArrayList<Node> tmp = new ArrayList<Node>();
					names.add(new CityName(j, sc.readLine()));
					int p = sc.nextInt();
					for (int k =0; k < p; k++) {
						int a, b;
						a = sc.nextInt();
						b = sc.nextInt();
						
						tmp.add(new Node(a, b));
					}
					graph.add(tmp);
				}
				
				Collections.sort(names);
				
				int r = sc.nextInt();
				
				for (int j = 0; j < r; j++) {
					String[] l = sc.readLine().split(" ");
					int from = binarySearch(l[0], names);
					int to = binarySearch(l[1], names);
					Dijkstra(from, to);
					System.out.println(dist[to]);
				}
			}
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
