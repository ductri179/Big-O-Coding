
package com.oscartran.codeforces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GukiZAndContest_551A {
    public static void main(String[] args) {
        int max = 2001;
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        
        List<Integer> b = new ArrayList<>();
        b.addAll(a);
        Collections.sort(b, Collections.reverseOrder());
        
        int[] c = new int[max];
        for (int i = 0; i < n; i++) {
            if (i>0 && b.get(i).equals(b.get(i-1))) {
                c[b.get(i)] = c[b.get(i-1)];
            } else {
                c[b.get(i)] = i;
            }
        }
        
        for (int i = 0; i < n; i++) {
            System.out.print((int)(c[a.get(i)]+1) + " ");
        }
    }
}
