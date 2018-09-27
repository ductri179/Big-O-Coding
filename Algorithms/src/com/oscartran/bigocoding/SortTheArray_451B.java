
package com.oscartran.codeforces.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class SortTheArray_451B {
      public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         
         int n = sc.nextInt();
         List<Integer> a = new ArrayList<>();
        
         for (int i = 1; i <= n; i++) {
             a.add(sc.nextInt());
         }
         
          List<Integer> b =  new ArrayList<>();
          b.addAll(a);
          
          Collections.sort(b);
          
          int l=0, r=0;
          for (int i = 0; i < n; i++) {
              if (!a.get(i).equals(b.get(i))) {
                    l = i;
                    break;
              }
          }
          for (int i = n-1; i >= 0; i--) {
              if (!a.get(i).equals(b.get(i))) {
                    r = i;
                    break;
              }
          }
          
          int left = l+1, right = r+1;
          while (l<r) {
              int tmp = a.get(l);
              a.set(l, a.get(r));
              a.set(r, tmp);
              l++;
              r--;
          }
          
          for (int i = 0; i < a.size(); i++) {
              if (!a.get(i).equals(b.get(i))) {
                  System.out.println("no");
                  return;
              }
          }
          
          System.out.println("yes");
          System.out.println(left + " " + right);
      }
}
