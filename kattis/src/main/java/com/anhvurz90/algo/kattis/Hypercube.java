package com.anhvurz90.algo.kattis;

import java.math.BigInteger;
import java.util.Scanner;

public class Hypercube {
    
    private static final BigInteger two = BigInteger.valueOf(2);

    public static void main(String[] args) throws Exception {
        new Hypercube().run();
    }
    
    private void run() throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] triples = sc.nextLine().split(" ");
        
        int n = Integer.parseInt(triples[0]);
        String a = triples[1];
        String b = triples[2];
        
        BigInteger aPos = getPos(a);
        BigInteger bPos = getPos(b);
        
        System.out.println(bPos.subtract(aPos).subtract(BigInteger.ONE).toString());
        
        sc.close();
    }
    
    private BigInteger getPos(String st) {
        if (st.length() == 1) {
            return BigInteger.valueOf(Integer.parseInt(st));
        }
        if (st.charAt(0) == '0') {
            return getPos(st.substring(1));
        }
        return two.pow(st.length()).subtract(BigInteger.ONE).subtract(getPos(st.substring(1)));
    }
}
