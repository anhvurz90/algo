package com.anhvurz90.algo.kattis;

import java.util.Scanner;

public class Geppetto {

    public static void main(String[] args) throws Exception {
        new Geppetto().run();
    }
    
    private int n, m;
    private boolean[][] noMix;
    private boolean[] flag;
    private int count = 0;
    
    private void run() throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        noMix = new boolean[n][n];
        flag = new boolean[n];
        for (int i = 0; i < m; i++) {
            byte a = sc.nextByte();
            byte b = sc.nextByte();
            noMix[a-1][b-1] = true;
            noMix[b-1][a-1] = true;
        }
        sc.close();
        tri(0);
        System.out.println(count);
    }
    
    private void tri(int pos) {
        if (pos == n) {
            count ++;
        } else {
            boolean ok = true;
            for (int i = 0; i < pos; i++) {
                if (flag[i] && noMix[i][pos]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                flag[pos] = true;
                tri(pos + 1);
            }
            flag[pos] = false;
            tri(pos+1);
        }
    }
}
