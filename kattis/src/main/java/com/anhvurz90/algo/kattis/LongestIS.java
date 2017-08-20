//package com.anhvurz90.algo.kattis;

import java.io.IOException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LongestIS {

    public static void main(String[] args) throws IOException {
        new LongestIS().run();
    }
    
    int[] val;
    int[] size;
    int[] next;
    private void run() {
        Scanner sc = 
              new Scanner(System.in);
//              new Scanner(new File("longest.inp"));
        
        try {
            while (true) {
                int n = sc.nextInt();
                val = new int[n];
                size = new int[n];
                next = new int[n];
                
                for (int i = 0; i < n; i++) {
                    val[i] = sc.nextInt();
                }
                
                Arrays.fill(size, 1);
                Arrays.fill(next, -1);
                int max = 0;
                int start = 0;
                for (int a = n-1; a >= 0; a--) {
                    for (int b = a-1; b >= 0; b--) {
                        if (val[b] < val[a] && size[b] < size[a] + 1) {
                            size[b] = size[a] + 1;
                            next[b] = a;
                        }
                    }
                    if (max < size[a]) {
                        max = size[a];
                        start = a;
                    }

                }
                System.out.println(max);
                String s = "";
                while (start != -1) {
                    s+= start;
                    start = next[start];
                    if (start != -1) {
                        s+= " ";
                    }
                }
                System.out.println(s);
            }
        } catch (NoSuchElementException e) {
            return;
        } finally {
            sc.close();
        }
    }
}
