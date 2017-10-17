//package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dvds {

    public static void main(String[] args) throws NumberFormatException, IOException {
        new Dvds().run();
    }
    
    private void run() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());
        for (int testId = 0; testId < testCount; testId++) {
            int n = Integer.parseInt(br.readLine());
            int[] stack = new int[n];
            int count = 0;
            for (String numStr: br.readLine().split(" ")) {
                stack[count++] = Integer.parseInt(numStr);
            }
            int[] pos = new int[n];
            
            for (int i = 0; i < n; i++) {
                pos[stack[i]-1] = i;
            }
            
            int moves = 0;
            for (int i = 0; i < n-1; i++) {
                if (pos[i+1] < pos[i]) {
                    moves = n - i - 1;
                    break;
                }
            }
            System.out.println(moves);
        }
        br.close();
    }
}
