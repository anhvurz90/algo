package com.anhvurz90.algo.hackerrank.algorithms.implementations;

import java.util.Scanner;

public class LarrysArray {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int iT = 0; iT < t; iT++) {
            String answer = "YES";
            
            int n = in.nextInt();
            int[] a = new int[n];
            int[] pos = new int [n+1];
            for (int iA = 0; iA < n; iA++) {
                a[iA] = in.nextInt();
                pos[a[iA]] = iA;
            }
            
            for (int iPos = 1; iPos <= n; iPos++) {
                if (pos[iPos] != iPos - 1) {
                    if (iPos == n-1) {
                        answer = "NO";
                        break;
                    } else {
                        while (pos[iPos] != iPos - 1) {
                            //rotate at pos[iPos] as center
                            int index = pos[iPos];
                            
                            if (index < n-1) {
                                rotate(a, pos, index);
                            } else {
                                rotate(a, pos, index - 1);
                            }
                        }
                    }
                }
            }
            
            System.out.println(answer);
        }
    }
    
    private static void rotate(int[] a, int[] pos, int index) {
        int tmp = a[index-1];
        a[index - 1] = a[index];
        a[index] = a[index + 1];
        a[index + 1] = tmp;

        pos[a[index-1]] = index-1;
        pos[a[index]] = index;
        pos[a[index+1]] = index+1;

    }
}
