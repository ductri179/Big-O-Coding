package com.oscartran;

import java.util.Arrays;

class MaxHeap {
	private int[] heap;
	private int heapSize;
	private int capacity;

	public MaxHeap() {
		heap = new int[1];
		capacity = 1;
		heapSize = 0;
	}

	public MaxHeap(int[] h, int cap) {
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

		if (left < heapSize && heap[left] > heap[biggest]) {
			biggest = left;
		}

		if (right < heapSize && heap[right] > heap[biggest]) {
			biggest = right;
		}

		if (biggest != i) {
			swap(i, biggest);
			MaxHeapify(biggest);
		}
	}

	private void swap(int lft_pos, int rht_pos) {
		int tmp = heap[lft_pos];
		heap[lft_pos] = heap[rht_pos];
		heap[rht_pos] = tmp;
	}

	private void pop() {
		if (heapSize == 0)
			return;
		heap[0] = heap[heapSize - 1];
		heapSize--;
		MaxHeapify(0);
	}

	private void	 push(int value) {
		if (heapSize == capacity) {
			capacity *= 2;
			heap = Arrays.copyOf(heap, capacity);
		}
		heap[heapSize] = value;
		heapSize++;
		int i = heapSize - 1;
		while (i != 0 && heap[(i - 1)/2] > heap[i]) {
			swap(i, (i-1)/2);
			i = (i-1)/2;
		}
	}
}
