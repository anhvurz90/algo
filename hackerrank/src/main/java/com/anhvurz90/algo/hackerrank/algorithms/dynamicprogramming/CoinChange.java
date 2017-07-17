package com.anhvurz90.algo.hackerrank.algorithms.dynamicprogramming;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CoinChange {
//public class Solution {

    static long getWays(int n, int[] c){
//        System.out.println("N: " + n);
//        for (int val: c) {
//            System.out.print(val + "; ");
//        }
//        System.out.println();
        
        long count[] = new long[n+1];
        count[0] = 1;
        for (int val: c) {
            for (int i = n; i >= 0; i--) {
                for (int times = 1; times <= n / val; times ++) {
//                    System.out.println("Val: " + val);
                    int value = times * val;
                    if (i + value <= n) {
                        count[i + value] += count[i];
                    }
                }
            }
//            for (long v: count) {
//                System.out.print(v + "; ");
//            }
//            System.out.println();
        }
        
        return count[n];
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = 
//                new Scanner(System.in);
                new Scanner(new File("CoinChange.in"));
        int n = in.nextInt();
        int m = in.nextInt();
        int[] c = new int[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextInt();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c);
        
        System.out.println(ways);
    }
}