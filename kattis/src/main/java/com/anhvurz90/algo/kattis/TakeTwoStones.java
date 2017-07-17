package com.anhvurz90.algo.kattis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TakeTwoStones {

    public static void main(String[] args) throws FileNotFoundException {
        new TakeTwoStones().run();
    }
    
    private void run() throws FileNotFoundException {
        Scanner sc = //new Scanner(System.in);
                new Scanner(new File("TakeTwoStones.inp"));
        
        int n = sc.nextInt();
        System.out.println(n % 2 == 1 ? "Alice" : "Bob");
        sc.close();
    }
}
