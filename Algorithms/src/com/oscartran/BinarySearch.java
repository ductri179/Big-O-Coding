package com.oscartran;

import java.util.ArrayList;

class BinarySearch {

	public static void main(String[] args) {

	}
	
	static int binarySearch(String name, ArrayList<String> list) {
		int l = 0, r = list.size()-1;
		while (l <= r) {
			int i = (r+l)/2;
			if (name.compareTo(list.get(i)) > 0) {
				l = i + 1;
			} else if (name.compareTo(list.get(i)) < 0) {
				r = i - 1;
			} else {
				return i;
			}
		}
		return -1;
	}

}
