
package com.oscartran.codeforces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Array_224B {
    public static void main(String[] args) {
        int max = (int)10e5 + 1;
        int c[] = new int[max];
        
        Scanner sc = new Scanner(System.in);
        
        int n, k, count = 0;
        n = sc.nextInt();
        k = sc.nextInt();
        
        List<Integer> arr = new ArrayList<>();
        arr.add(0);
        
        for (int i = 1; i <= n; i++) {
            arr.add(sc.nextInt());
        }
        
        for (int i = 1; i <= n; i++) {
            c[arr.get(i)]++;
            if (c[arr.get(i)] == 1) {
                count++;
            }
            int j = 0;
            while (count == k ) {
                j++;
                c[arr.get(j)]--;
                if (c[arr.get(j)] == 0) {
                    System.out.println(j + " " + i);
                    return;
                }
            }
        }
        System.out.println("-1 -1");
        
    }
}
