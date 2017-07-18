package com.anhvurz90.algo.hackerrank.algorithms.implementations;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BirthdayChocolate {
//public class Solution {

    static int solve(int n, int[] s, int d, int m){
        int count = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += s[i];
            if (i >= m) {
                sum -= s[i-m];
            }
            if (i >= m-1) {
                if (sum == d) {
                    count ++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        int result = solve(n, s, d, m);
        System.out.println(result);
    }
}
