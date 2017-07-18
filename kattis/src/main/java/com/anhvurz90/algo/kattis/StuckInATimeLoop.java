package com.anhvurz90.algo.kattis;

import java.util.Scanner;

public class StuckInATimeLoop {
    
    public static void main(String[] args) {
        new StuckInATimeLoop().run();
    }
    
    private void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 1; i <=n; i++) {
            System.out.format("%d %s\n", i, "Abracadabra");
        }
        
        sc.close();
    }

}
