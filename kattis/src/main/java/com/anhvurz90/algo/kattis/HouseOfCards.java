//package com.anhvurz90.algo.kattis;

import java.math.BigInteger;
import java.util.Scanner;

public class HouseOfCards {

    public static void main(String[] args) {
        new HouseOfCards().run();
    }
    
    private void run() {
        Scanner sc = new Scanner(System.in);
        String hSt = sc.nextLine();
        sc.close();
        
        BigInteger h = new BigInteger(hSt);
        BigInteger two = BigInteger.valueOf(2);
        BigInteger three = BigInteger.valueOf(3);
        BigInteger four = BigInteger.valueOf(4);
        
        while (true) {
            BigInteger h1 = h.add(BigInteger.ONE);
            BigInteger val = three.multiply(h)
                                  .multiply(h1)
                                  .divide(two)
                                  .subtract(h);
            if (val.mod(four).equals(BigInteger.ZERO)) {
                System.out.println(h);
                break;
            }
            h = h1;
        }
    }
}
