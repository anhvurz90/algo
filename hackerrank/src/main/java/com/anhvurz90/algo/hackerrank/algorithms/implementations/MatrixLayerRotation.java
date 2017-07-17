package com.anhvurz90.algo.hackerrank.algorithms.implementations;

import java.util.Scanner;

public class MatrixLayerRotation {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int r = in.nextInt();
        
        int[][] a = new int[m][n];
        for (int iM = 0; iM < m; iM++) {
            for (int iN = 0; iN < n; iN++) {
                a[iM][iN] = in.nextInt();
            }
        }
        
        rotate(a, 0, 0, m-1, n-1, r);
        
        for (int iM = 0; iM < m; iM++) {
            for (int iN = 0; iN < n-1; iN++) {
                System.out.print(a[iM][iN] + " ");    
            }
            System.out.println(a[iM][n-1]);
        }
        
        in.close();
    }
    
    private static void rotate(int[][] a, int topx, int topy, int botx, int boty, int count) {
        if (topx <= botx && topy <= boty) {
            for (int i = 0; i < (count % (2 * (botx - topx + boty - topy))); i ++) {
                rotateOne(a, topx, topy, botx, boty);
            }
            rotate(a, topx + 1, topy + 1, botx - 1, boty - 1, count);
        }
    }
    
    private static void rotateOne(int[][] a, int topx, int topy, int botx, int boty) {
        //System.out.println(String.format("%d %d %d %d", topx, topy, botx, boty));
        int tmp = a [topx][topy];
        for (int i = topy; i < boty; i++) 
            a[topx][i] = a[topx][i+1];
        for (int j = topx; j < botx; j++)
            a[j][boty] = a[j+1][boty];
        for (int i = boty; i > topy; i--)
            a[botx][i] = a[botx][i-1];
        for (int j = botx; j > topx; j--)
            a[j][topy] = a[j-1][topy];
        a[topx+1][topy] = tmp;
    }
}