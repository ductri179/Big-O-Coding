package com.oscartran;

public class BinarySearchFirst {

	public static int bsFirst(int[] arr, int l, int r, int x) {
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if ((mid == l || x > arr[mid - 1]) && arr[mid] == x) {
				return mid;
			} else if (x > arr[mid]) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

	}

}
