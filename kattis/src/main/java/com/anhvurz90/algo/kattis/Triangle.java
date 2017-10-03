package com.anhvurz90.algo.kattis;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Triangle {

    public static void main(String[] args) throws FileNotFoundException {
        new Triangle().run();
    }
    
    private void run() throws FileNotFoundException {
        Scanner sc = 
                new Scanner(System.in);
        
        int count = 0;

        int pow2Len = 20;
        int[] pow2 = new int[pow2Len];pow2[0] = 1;
        BigDecimal[] oneHalf = new BigDecimal[pow2Len];oneHalf[0] = new BigDecimal(1.5);
        for (int i = 1; i < pow2Len; i++) { 
            pow2[i] = 2 * pow2[i-1];
            oneHalf[i] = oneHalf[i-1].multiply(oneHalf[i-1]);
        }
        
        while (sc.hasNextInt()) {
            int n = sc.nextInt();

            BigDecimal val = new BigDecimal(3);
            for (int i = 0; i < pow2Len; i++) {
                if ((n & pow2[i]) == pow2[i]) {
                    val = val.multiply(oneHalf[i]);
                }
            }
            
            System.out.println("Case " + ++count + ": " + val.toBigInteger().toString().length());
        }
        sc.close();
    }

}
