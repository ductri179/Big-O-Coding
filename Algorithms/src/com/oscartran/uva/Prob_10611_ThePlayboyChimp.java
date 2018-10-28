package com.oscartran.uva;

import java.util.Scanner;

class Prob_10611_ThePlayboyChimp {

	static int bsFirst(int[] arr, int l, int r, int x) {
		if (l <= r) {
			int mid = l + (r - l) / 2;
			if ((mid == l || x > arr[mid - 1]) && arr[mid] == x) {
				if (mid > 0)
					return mid - 1;
				return -1;
			}
			else if (x > arr[mid])
				return bsFirst(arr, mid + 1, r, x);
			else 
				return bsFirst(arr, l, mid - 1, x);
		}
		
		return -1;
	}

	static int upper_bound(int[] arr, int l, int r, int x) {
		int pos = l;
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] <= x) {
				pos = mid;
				l = mid;
			} else {
				r = mid - 1;
			}
		}
		if (arr[pos] == x) {
			if (pos < r - 1)
				return pos + 1;
			else
				return -1;
		}
		return pos;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, q, h;
		n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		q = sc.nextInt();
		while (q > 0) {
			q--;
			h = sc.nextInt();
			int u, l;
//			u = upper_bound(arr, 0, n - 1, h);
			l = lower_bound(arr, 0, n - 1, h);
			System.out.println(l);
//			if (u == -1)
//				System.out.println(arr[l] + " X");
//			else if (l == -1)
//				System.out.println("X " + arr[u]);
//			else
//				System.out.println(arr[l] + " " + arr[u]);
		}
		sc.close();
	}

}
