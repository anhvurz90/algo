package com.anhvurz90.algo.kattis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class R2 {
    public static void main(String[] args) throws FileNotFoundException {
        new R2().run();
    }
    
    private void run() throws FileNotFoundException {
        Scanner sc = //new Scanner(System.in);
                new Scanner(new File("R2.inp"));
        
        int a = sc.nextInt();
        int s = sc.nextInt();
        System.out.println(2 * s - a);
        sc.close();
    }
}
