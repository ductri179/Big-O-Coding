
package com.oscartran.codeforces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeorgeandRound_387B {
    public static void main(String args[]) {
        int max = (int) 10e6 + 1;
        Scanner sc = new Scanner(System.in);
       
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        
        List<Integer> a = new ArrayList<>();
        int[] b = new int[max];
        
        for (int i=0; i<n; i++) {
            a.add(sc.nextInt());
        }
        
        for (int i=0; i<m; i++) {
            b[sc.nextInt()]++;
        }
        
        for (int i=0; i<a.size(); i++) {
            if (b[a.get(i)] > 0) {
                b[a.get(i)]--;
                a.remove(i--);
            }
        }
        
        int j = a.size() > 0? a.get(0) : 0;
        for (int i=0; i<a.size(); i++) {
            for (; j < max; j++) {
                if (b[j] >0) {
                    b[j--]--;
                    a.remove(i--);
                    break;
                }
            }
        }
        
        System.out.println(a.size());
    }
}
