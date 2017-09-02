//package com.anhvurz90.algo.kattis;

import java.util.Scanner;

public class Natjecanje {

    public static void main(String[] args) {
        new Natjecanje().run();
    }

    private int n;
    private int dmg;
    private int r;
    boolean dmgs[];
    boolean rs[];
    private int ret;
    
    private void run() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        dmg = sc.nextInt();
        r = sc.nextInt();
        
        dmgs = new boolean[n];
        rs = new boolean[n];
        
        for (int i = 0; i < dmg; i++) {
            dmgs[sc.nextInt()-1] = true;
        }
        
        for (int i = 0; i < r; i++) {
            rs[sc.nextInt()-1] = true;
        }
        
        for (int i = 0; i < n; i++) {
            if (dmgs[i] && rs[i]) {
                dmgs[i] = false;
                rs[i] = false;
                dmg --;
                r --;
            }
        }
        
        ret = n;
        findMin(0);
        System.out.println(ret);
        
        sc.close();
    }

    private void findMin(int index) {
        if (index == n) {
            checkDmgs();
        } else {
            findMin(index + 1);

            if (dmgs[index]) {
                if (index > 0 && rs[index-1]) {
                    rs[index-1] = false;
                    dmgs[index] = false;
                    findMin(index + 1);
                    rs[index-1] = true;
                    dmgs[index] = true;
                }
                if (index < n-1 && rs[index+1]) {
                    rs[index+1] = false;
                    dmgs[index] = false;
                    findMin(index + 1);
                    rs[index+1] = true;
                    dmgs[index] = true;
                }
            }
        }
    }

    private void checkDmgs() {
        int count = 0;
        for (boolean b : dmgs) {
            if (b) {
                count ++;
            }
        }
        ret = Math.min(ret, count);
    }
}
