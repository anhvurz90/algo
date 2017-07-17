package com.anhvurz90.algo.kattis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Pot {
    public static void main(String[] args) throws FileNotFoundException {
        new Pot().run();
    }
    
    private void run() throws FileNotFoundException {
        Scanner sc = 
//                new Scanner(System.in);
                new Scanner(new File("Pot.inp"));
        
        int n = sc.nextInt();
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int pow = p % 10;
            p /= 10;
            ret += Math.pow(p, pow);
        }
        System.out.println(ret);
        sc.close();
    }
}
