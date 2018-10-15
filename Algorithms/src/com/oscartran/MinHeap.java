package com.oscartran;

import java.util.Arrays;

class MinHeap {
	private int[] heap;
	private int heapSize;
	private int capacity;
	
	public MinHeap() {
		heap = new int[1];
		capacity = 1;
		heapSize = 0;
	}
	
	public MinHeap (int[] h, int cap) {
		capacity = cap;
		heapSize = h.length;
		heap = Arrays.copyOf(h, cap);
		buildHeap();
	}

	private void buildHeap() {
		for (int i = heapSize / 2 - 1; i >= 0; i--) {
			MinHeapify(i);
		}
	}
	
	private void MinHeapify(int i) {
		int smallest = i;
		int left = 2*i + 1;
		int right = 2*i + 2;
		
		if (left < heapSize && heap[left] < heap[smallest]) {
			smallest = left;
		}
		
		if (right < heapSize && heap[right] < heap[smallest]) {
			smallest = right;
		}
		
		if (smallest != i) {
			swap(i, smallest);
			MinHeapify(smallest);
		}
	}

	private void swap(int lft_pos, int rht_pos) {
		int tmp = heap[lft_pos];
		heap[lft_pos] = heap[rht_pos];
		heap[rht_pos] = tmp;
	}
}
