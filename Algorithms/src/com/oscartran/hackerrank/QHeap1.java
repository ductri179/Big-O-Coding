package com.oscartran.hackerrank;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.PriorityQueue;

public class QHeap1 {
	public static void main(String[] args) {
		try {
			Reader sc = new Reader();
			int Q;

			Q = sc.nextInt();

			PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

			for (int i = 0; i < Q; i++) {
				int c, v;
				c = sc.nextInt();
				

				switch (c) {
				case 1:
					v = sc.nextInt();
					heap.add(v);
					break;

				case 2:
					v = sc.nextInt();
					heap.remove(v);
					break;
					
				case 3: 
					System.out.println(heap.peek());
				}
				
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
