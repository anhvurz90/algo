package com.anhvurz90.algo.hackerrank.contests;

import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();

        int[] tasks = new int[n];
        int count = 0;
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            tasks[i] = in.nextInt();
            sum += tasks[i];
            if (sum <= t) {
                count ++;
            } else {
                break;
            }
        }
        System.out.println(count);
        in.close();
    }

}
