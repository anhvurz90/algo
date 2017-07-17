package com.anhvurz90.algo.kattis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReversedBinaryNumbers {
    public static void main(String[] args) throws FileNotFoundException {
        new ReversedBinaryNumbers().run();
    }
    
    private void run() throws FileNotFoundException {
        Scanner sc = //new Scanner(System.in);
                new Scanner(new File("ReversedBinaryNumbers.inp"));
        
        int n = sc.nextInt();
        int ret = 0;
        while (n > 0) {
            ret += (n % 2);
            ret *= 2;
            n /= 2;
        }
        System.out.println(ret / 2);
        sc.close();
    }
}
