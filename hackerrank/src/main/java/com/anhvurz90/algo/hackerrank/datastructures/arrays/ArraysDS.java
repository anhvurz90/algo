package com.anhvurz90.algo.hackerrank.datastructures.arrays;

import java.util.Scanner;

public class ArraysDS {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = "";
        for (int i = 0; i < n; i++) {
            int aI = in.nextInt();
            s = i == 0 ? String.valueOf(aI) : aI + " " + s;
        }
        System.out.println(s);
    }
}