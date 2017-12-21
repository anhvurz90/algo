package com.anhvurz90.algo.kattis;

import java.util.Scanner;

public class Matrix {

    public static void main(String[] args) {
        new Matrix().run();
    }
    
    private void run() {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while (sc.hasNextLine()) {
            String[] p1 = sc.nextLine().split(" " );
            long a = Long.parseLong(p1[0]);
            long b = Long.parseLong(p1[1]);
            
            String[] p2 = sc.nextLine().split(" ");
            long c = Long.parseLong(p2[0]);
            long d = Long.parseLong(p2[1]);
            
            if (sc.hasNextLine()) {
                sc.nextLine();
            }
            
            long determinal = a*d - b*c;
//            d -b
//            -c a
            long e = d / determinal;
            long f = (-b) / determinal;
            long g = (-c) / determinal;
            long h = a / determinal;
            
            System.out.format("Case %d:\n", ++count);
            System.out.format("%d %d\n",  e, f);
            System.out.format("%d %d\n", g, h);
        }
    }
}
