package com.anhvurz90.algo.kattis;

import java.util.Scanner;

public class WeakVerticies {

    public static void main(String[] args) {
        new WeakVerticies().run();
    }
    
    private void run() {
        Scanner sc = new Scanner(System.in);

        do {
            int n = sc.nextInt();
            if (n == -1) break;
            
            int[][] graph = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = sc.nextInt();
                }
            }
            
            int[] strong = new int[n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) 
                    if (r != c && graph[r][c] == 1) {
                        for (int k = 0; k < n; k++) {
                            if (k != n && k != c && graph[k][r] == 1 && graph[k][c] == 1) {
                                strong[r] = 1;
                                strong[k] = 1;
                                strong[c] = 1;
                            }
                        }
                    }
            }
            String ret = "";
            for (int i = 0; i < n; i++) {
                if (strong[i] == 0) {
                    ret += i + " ";
                }
            }
            System.out.println(ret.length() > 0 ? ret.substring(0, ret.length() - 1) : ret);
        } while (true);
        sc.close();
    }

}
