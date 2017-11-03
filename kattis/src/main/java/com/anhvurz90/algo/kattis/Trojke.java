package com.anhvurz90.algo.kattis;

import java.util.Scanner;

public class Trojke {

    public static void main(String[] args) {
        new Trojke().run();
    }
    
    private void run() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] board = new String[n];
        for (int i = 0; i < n; i++) {
            board[i] = sc.nextLine();
        }
        sc.close();
        
        long count = 0;
        for (int row1 = 0; row1 < n; row1++) {
            for (int col1 = 0; col1 < n; col1++) {
                if (board[row1].charAt(col1) != '.') {
                    for (int row2 = row1 + 1; row2 < n-1; row2++) {
                        for (int col2 = 0; col2 < n; col2++) {
                            if (board[row2].charAt(col2) != '.') {
                                int r = row2 - row1;
                                int c = col2 - col1;
                                for (int row3 = row2 + 1; row3 < n; row3++) {
                                    int r1 = row3 - row1;
                                    if (c * r1 % r == 0) {
                                        int col3 = col1 + c * r1 / r;
                                        if (col3 >= 0 && col3 < n && board[row3].charAt(col3) !=  '.') {
                                            count ++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        for (int row = 0; row < n; row++) {
            long cc = 0;
            for (int col = 0; col < n; col++) {
                if (board[row].charAt(col) != '.') {
                    cc ++;
                }
            }
            count += c3(cc);
        }
        System.out.println(count);
    }
    
    private long c3(long n) {
        return n * (n-1) * (n-2) / 6;
    }
}
