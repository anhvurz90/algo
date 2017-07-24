//package com.anhvurz90.algo.kattis;

import java.util.Scanner;

public class TheMailboxManufacturers {

    int[][][] f;
    
    public static void main(String[] args) {
        new TheMailboxManufacturers().run();
    }
    
    
    int findMin(int lo, int hi, int box_num) {
//        print(lo, hi, box_num);
        if (f[lo][hi][box_num] == 5050) {
            if (box_num == 1)
                f[lo][hi][box_num] = (lo + hi)*(hi-lo+1) / 2;
            else if (lo == hi)
                f[lo][hi][box_num] = lo;
            else if (lo > hi)
                f[lo][hi][box_num] = 0;
            else {
                int minV = 5050;
                for (int i = 0; i < hi - lo; i++) 
                    minV = Math.min(minV, (lo + i) + Math.max(findMin(lo, lo + i - 1, box_num - 1), findMin(lo + i + 1, hi, box_num)));
                f[lo][hi][box_num] = minV;
            }
        }
        return f[lo][hi][box_num];
    }
    
    private void run() {
        Scanner sc = new Scanner(System.in);
//                new Scanner(new File("R2.inp"));
        
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            int m = sc.nextInt();
            f = new int[m+1][m+1][k+1];
            for (int a = 0; a <= m; a++)
                for (int b = 0; b <= m; b++)
                    for (int c = 0; c <=k; c++)
                        f[a][b][c] = 5050;
            System.out.println(findMin(1, m, k));
        }
        sc.close();
    }
}
