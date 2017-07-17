package com.anhvurz90.algo.kattis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Oddities {
    public static void main(String[] args) throws FileNotFoundException {
        new Oddities().run();
    }
    
    private void run() throws FileNotFoundException {
        Scanner sc = 
//                new Scanner(System.in);
                new Scanner(new File("Oddities.inp"));
        
        int n = sc.nextInt();
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            System.out.format("%d is %s\n", num, num %2 == 0 ? "even" : "odd");
        }
        sc.close();
    }
}
