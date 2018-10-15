package com.oscartran.uva;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.PriorityQueue;

/*
 * Ý tưởng:
 * 
 * Dùng min heap
 * 
 * Lần đầu tiên remove 2 phần tử đầu tiên ra cộng lại, kết quả sẽ được add vào heap 
 * cứ làm tiếp tục cho đến khi heap chỉ còn 1 phần tử. sau mỗi lần cộng kết quả được lưu lại vào biến cost.
 * cuối cùng in ra cost 
 * 
 * */

class Prob_10954 {

	public static void main(String[] args) {
		try {
			int N;
			Reader sc = new Reader();
			
			N = sc.nextInt();
			while(N != 0) {
				PriorityQueue<Long> heap = new PriorityQueue<Long>();
				for (int i = 0; i < N; i++) {
					heap.add(sc.nextLong());
				}
				Long cost = 0l;
				while(heap.size() > 1) {
					long sum = heap.remove() + heap.remove();
					heap.add(sum);
					cost += sum;
				}
				System.out.println(cost);
				N = sc.nextInt();
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
