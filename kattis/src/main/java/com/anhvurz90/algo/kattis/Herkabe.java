package com.anhvurz90.algo.kattis;

import java.util.Arrays;
import java.util.Scanner;

public class Herkabe {
    
    private static final Long MODULO = 1000000007L;

    public static void main(String[] args) {
        new Herkabe().run();
    }
    
    int n;
    String[] names;
    int[] commonPrefix;
    long[] gt;
    private void run() {
        Scanner sc = 
                new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.nextLine();
        }
        Arrays.sort(names);
        
        creatGt(n);
        
        commonPrefix = new int[n];
        for (int i = 0; i < n-1; i++) {
            commonPrefix[i] = commonPrefixCount(names[i], names[i+1]);
            //System.out.println(names[i] + ": " + commonPrefix[i]);
        }
        
        System.out.println(f(0, n-1));
        
        sc.close();
    }
    
    private void creatGt(int n) {
        gt = new long[n+1];
        gt[0] = 1L;
        for (int i = 1; i <= n; i++) {
            gt[i] = (gt[i-1] * i) % MODULO;
        }
    }
    
    private long f(int from, int to) {
        if (from == to) {
            return 1;
        }
        int c = minCommon(from, to-1);
        removeCommon(from, to-1, c);
        
        long ret = 1;
        int prev = from-1;
        int count = 0;
        for (int i = from; i <= to; i++) {
            if (commonPrefix[i] == 0) {
                count ++;
                ret *= f(prev+1, i);
                ret %= MODULO;
                prev = i;
            }
        }
        
        ret *= gt[count];
        ret %= MODULO;
        
        return ret;
    }
    
    private void removeCommon(int from, int to, int c) {
        for (int i = from; i <= to; i++) {
            commonPrefix[i] -= c;
        }
    }

    private int minCommon(int from, int to) {
        int min = commonPrefix[from];
        for (int i = from; i <= to; i++) {
            min = Math.min(min, commonPrefix[i]);
        }
        return min;
    }

    private int commonPrefixCount(String s1, String s2) {
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return i;
            }
        }
        return Math.min(s1.length(), s2.length());
    }
}
