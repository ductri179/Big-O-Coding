
package com.oscartran.codeforces.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Chores_169A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, a, b;
        n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        
        List<Integer> c = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            c.add(sc.nextInt());
        }
        
        Collections.sort(c);
        
        int x1 = c.get(b-1);
        int x2 = c.get(b);
        System.out.println(x2-x1);
    }
}
