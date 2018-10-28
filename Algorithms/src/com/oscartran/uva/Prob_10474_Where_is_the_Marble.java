package com.oscartran.uva;

import java.util.Arrays;
import java.util.Scanner;

class Prob_10474_Where_is_the_Marble {
	
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
		Scanner sc = new Scanner(System.in);
		int n, q;
		
		n = sc.nextInt();
		q = sc.nextInt();
		
		int [] arr;
		int count = 1;
		while (n != 0 && q != 0) {
			System.out.println("CASE# " + count + ":");
			count++;
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			for (int j = 0; j < q; j++) {
				int x = sc.nextInt();
				int pos = bsFirst(arr, 0, n-1, x);
				if (pos != -1 && arr[pos]== x) {
					System.out.println(x + " found at " + new Integer(pos+1));
				} else {
					System.out.println(x + " not found");
				}
			}
			n = sc.nextInt();
			q = sc.nextInt();
		}
		sc.close();
	}

}
