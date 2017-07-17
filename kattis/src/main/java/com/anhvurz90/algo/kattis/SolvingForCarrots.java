package com.anhvurz90.algo.kattis;

import java.io.File;
import java.util.Scanner;

public class SolvingForCarrots {

    public static void main(String[] args) throws Exception {
        new SolvingForCarrots().run();
    }
    
    private void run() throws Exception {
        Scanner sc = //new Scanner(System.in);
            new Scanner(new File("SolvingForCarrots.inp"));
        int n = sc.nextInt();
        int p = sc.nextInt();
        System.out.println(p);
        sc.close();
    }

}
