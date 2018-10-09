package com.oscartran.hackerearth;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {

	public static void main(String[] args) {
		try {
			Reader sc = new Reader();
			PriorityQueue<Long> heap = new PriorityQueue<Long>(new Comparator<Long>() {
				@Override
				public int compare(Long o1, Long o2) {
					return o2.compareTo(o1);
				}
			});
			
			int N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				heap.add(sc.nextLong());
				if (i == 0 || i == 1) {
					System.out.println(-1);
				} else {
					long f = heap.remove();
					long s = heap.remove();
					long t = heap.remove();
					System.out.println(f*s*t);
					heap.add(f);
					heap.add(s);
					heap.add(t);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return;
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
		
		public long nextLong() throws IOException 
	    { 
	        long ret = 0; 
	        byte c = read(); 
	        while (c <= ' ') 
	            c = read(); 
	        boolean neg = (c == '-'); 
	        if (neg) 
	            c = read(); 
	        do { 
	            ret = ret * 10 + c - '0'; 
	        } 
	        while ((c = read()) >= '0' && c <= '9'); 
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
