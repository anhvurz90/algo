package com.anhvurz90.algo.hackerrank.algorithms.sorting;

import java.util.Scanner;

public class IntroToTutorialChallenges {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int v = in.nextInt();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int val = in.nextInt();
            if (val == v) {
                System.out.println(i);
            }
        }
    }
}
