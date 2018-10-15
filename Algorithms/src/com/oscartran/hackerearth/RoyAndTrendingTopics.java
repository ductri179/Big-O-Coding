package com.oscartran.hackerearth;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Ý tưởng: dùng max heap 
 * 
 * Mỗi topic được lưu lại dưới dạng mảng gồm: id, old score, new score, change score
 * 
 * Trong hàm heapify ngoài xét giá trị change score còn xét cả giá trị id để đảm bảo
 *  phần tử đầu heap luôn có giá trị lớn nhất của change score, nếu change score bằng nhau thì id lớn hơn sẽ nằm trước
 *  
 *  in ra kết quả chỉ việc lần lượt lấy ra phần tử đầu tiên của heap 
 * 
 * */

class RoyAndTrendingTopics {

	public static void main(String[] args) {
		try {
			Reader sc = new Reader();

			int N;
			N = sc.nextInt();
			
			ArrayList<Long>[] arr = new ArrayList[N]; 
			
			for (int i = 0; i < N; i++) {
				ArrayList<Long> tmp = new ArrayList<Long>();
				long old_z, new_z, id;
				id = sc.nextLong();
				old_z = sc.nextLong();
				new_z = sc.nextLong()*50 + sc.nextLong()*5 + sc.nextLong()*10 + sc.nextLong()*20;
				tmp.add(id);
				tmp.add(old_z);
				tmp.add(new_z);
				tmp.add(new_z - old_z);
				arr[i] = tmp;
			}
			
			MaxHeap heap = new MaxHeap(arr, N);
			for (int i = 0; i < (N > 5 ? 5 : N); i++) {
				ArrayList<Long> tmp = heap.pop();
				System.out.println(tmp.get(0) + " " + tmp.get(2));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static class MaxHeap {
		private ArrayList<Long>[] heap;
		private int heapSize;
		private int capacity;

		public MaxHeap() {
			heap = new ArrayList[1];
			capacity = 1;
			heapSize = 0;
		}

		public MaxHeap(ArrayList<Long>[] h, int cap) {
			capacity = cap;
			heapSize = h.length;
			heap = Arrays.copyOf(h, cap);
			buildHeap();
		}

		private void buildHeap() {
			for (int i = heapSize / 2 - 1; i >= 0; i--) {
				MaxHeapify(i);
			}
		}

		private void MaxHeapify(int i) {
			int biggest = i;
			int left = 2 * i + 1;
			int right = 2 * i + 2;

			if (left < heapSize) {
				if (heap[left].get(3) > heap[biggest].get(3)) 
					biggest = left;
				else if (heap[left].get(3) == heap[biggest].get(3)) {
					if (heap[left].get(0) > heap[biggest].get(0)) 
						biggest = left;
				}
			}

			if (right < heapSize) {
				if (heap[right].get(3) > heap[biggest].get(3)) 
					biggest = right;
				else if (heap[right].get(3) == heap[biggest].get(3)) {
					if (heap[right].get(0) > heap[biggest].get(0)) 
						biggest = right;
				}
			}

			if (biggest != i) {
				swap(i, biggest);
				MaxHeapify(biggest);
			}
		}

		private void swap(int lft_pos, int rht_pos) {
			ArrayList<Long> tmp = heap[lft_pos];
			heap[lft_pos] = heap[rht_pos];
			heap[rht_pos] = tmp;
		}
		
		private ArrayList<Long> pop() {
			if (heapSize == 0) {
				return null;
			}
			ArrayList<Long> ret = heap[0];
			heap[0] = heap[heapSize - 1];
			heapSize--;
			MaxHeapify(0);
			return ret;
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
