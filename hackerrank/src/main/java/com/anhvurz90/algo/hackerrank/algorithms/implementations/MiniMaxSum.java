package com.anhvurz90.algo.hackerrank.algorithms.implementations;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MiniMaxSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();
        long d = in.nextLong();
        long e = in.nextLong();
        
        long minElement = Math.min(a, Math.min(b, Math.min(c, Math.min(d, e))));
        long maxElement = Math.max(a, Math.max(b, Math.max(c, Math.max(d, e))));
        long sum = a + b + c + d + e;
        
        System.out.println(String.format("%d %d", sum - maxElement, sum - minElement));
    }
}
