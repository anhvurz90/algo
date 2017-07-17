package com.anhvurz90.algo.hackerrank.algorithms.implementations;

import java.util.Arrays;
import java.util.Scanner;

public class AlmostSorted {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int[] d = new int[n];
        int[] original = new int[n];
        
        for (int i = 0; i < n; i++) {
            d[i] = in.nextInt();
            original[i] = d[i];
        }
        
        Arrays.sort(d);
        
        if (swapOk(d, original)) {
            System.out.println("yes");
            System.out.format("swap %d %d", minDiffIndex(d, original) + 1, maxDiffIndex(d, original) + 1);
        } else if (reverseOk(d, original)) {
            System.out.println("yes");
            System.out.format("reverse %d %d\n", minDiffIndex(d, original) + 1, maxDiffIndex(d, original) + 1);
        } else {
            System.out.println("no");
        }
    }

    private static boolean swapOk(int[] d, int[] original) {
        int diffCount = 0;
        for (int i = 0; i < d.length; i++) {
            if (d[i] != original[i]) {
                diffCount ++;
            }
        }
        return diffCount == 2;
    }

    private static int minDiffIndex(int[] d, int[] original) {
        for (int i = 0; i < d.length; i++) {
            if (d[i] != original[i]) {
                return i;
            }
        }
        return -1;
    }

    private static int maxDiffIndex(int[] d, int[] original) {
        for (int i = d.length-1; i >= 0; i--) {
            if (d[i] != original[i]) {
                return i;
            }
        }
        return -1;
    }
    
    private static boolean reverseOk(int[] d, int[] original) {
        int lo = minDiffIndex(d, original);
        int hi = maxDiffIndex(d, original);
        
        int[] sub = new int[hi - lo + 1];
        System.arraycopy(original, lo, sub, 0, sub.length);
        
        for (int i = 0; i < sub.length - 1; i++) {
            if (sub[i] < sub[i+1]) {
                return false;
            }
        }
        
        return true;
    }

}
