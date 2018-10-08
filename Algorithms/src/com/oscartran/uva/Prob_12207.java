package com.oscartran.uva;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class Prob_12207 {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> outputs = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		while (!line.equals("0 0")) {
			String[] pc = line.split(" ");
			int P = Integer.parseInt(pc[0]);
			int C = Integer.parseInt(pc[1]);
			
			ArrayList<Integer> opt = new ArrayList<Integer>();
			LinkedList<Integer> q = new LinkedList<Integer>();
			for (int i = 1; i <= ((C < P)? C : P); i++) {
				q.add(i);
			}
			
			for (int i = 0; i < C; i++) {
				String l = sc.nextLine();
				if (l.equals("N")) {
					int f = q.remove();
					opt.add(f);
					q.add(f);
				} else {
					int E = Integer.parseInt(l.split(" ")[1]);
					boolean found = false;
					for (int j = 0; j < q.size(); j++) {
						if (E == q.get(j)) {
							q.remove(j);
							q.addFirst(E);
							found = true;
							break;
						}
					}
					if (!found) {
						q.addFirst(E);
					}
				}
			}
			outputs.add(opt);
			line = sc.nextLine();
 		}
		for (int i = 0; i < outputs.size(); i++) {
			System.out.println("Case " + Integer.toString(i+1) + ":");
			for (Integer n : outputs.get(i)) {
				System.out.println(n);
			}
		}
	}
}
