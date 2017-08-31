package com.anhvurz90.algo.kattis;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BlackFriday {
    
    public static void main(String[] args) {
        new BlackFriday().run();
    }

    
    private void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (m.containsKey(a[i])) {
                m.put(a[i], m.get(a[i]) + 1);
            } else {
                m.put(a[i], 1);
            }
        }
        sc.close();
        
        int maxIdx = -1;
        for (int i = 0; i < n; i++) {
            if ((m.get(a[i]) == 1) && (maxIdx == -1 || a[i] > a[maxIdx])) {
                maxIdx = i;
            }
        }
        System.out.println(maxIdx == -1 ? "none" : maxIdx+1);
        
    }
    
}
