package com.oscartran.spoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ONP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		List<String> exps = new ArrayList<String>();
		
		for (int i = 0; i < t; i++) {
			String exp = sc.nextLine();
			exps.add(exp);
		}
		
		for (int i = 0; i < t; i++) {
			String output = "";
			Stack<Character> operators = new Stack<Character>();
			String exp = exps.get(i);
			for (Character c : exp.toCharArray()) {
				if (isOperand(c)) {
					output += c;
				} else if (isOperator(c)) {
					//+-*/^
					operators.push(c);
				} else if (c == ')') {
					output += operators.pop();
				}
			}
			System.out.println(output);
		}
		sc.close();

	}

	private static boolean isOperator(Character ope) {
		if (ope == '+' || ope == '-' || ope == '*' || ope == '/' ||ope == '^') {
			return true;
		}
		return false;
	}

	private static boolean isOperand(Character ope) {
		if (ope >= 'a' && ope <= 'z') {
			return true;
		}
		return false;
	}

}
