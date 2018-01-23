package com.anhvurz90.algo.kattis;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Ratings {

    public static void main(String[] args) {
        new Ratings().run();
    }
    
    private void run() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (n > 0) {
                int[] rates = new int[n];
                for (int i = 0; i < n; i++) {
                    rates[i] = sc.nextInt();
                }
                System.out.println(rateUnder(rates).add(rate2(rates)));
            }
        }
        sc.close();
    }
    
    BigInteger[][] valEqual = null;
    BigInteger[][][] valEqual3 = null;
    private BigInteger rateUnder(int[] rates) {
        int sum = Arrays.stream(rates).sum();
        valEqual = new BigInteger[rates.length][sum+1];
        valEqual3 = new BigInteger[rates.length][sum+1][sum+1];
        
        BigInteger total = BigInteger.ZERO;
        for (int s = 0; s < sum; s++) {
            total = total.add(rateEqual(0, s));
        }
        
        return total;
    }
    
    private BigInteger rateEqual(int pos, int sum) {
        if (valEqual[pos][sum] == null) {
            BigInteger total = BigInteger.ZERO;
            for (int v = 0; v <= sum; v++) {
                total = total.add(rateEqual(pos, v, sum));
            }
            
            valEqual[pos][sum] = total;
        }
        return valEqual[pos][sum];
    }
    
    private BigInteger rateEqual(int pos, int v, int sum) {
        if (valEqual3[pos][v][sum] == null) {
            BigInteger ret = BigInteger.ZERO;
            if (pos == valEqual.length - 1) {
                ret = v == sum ? BigInteger.ONE : BigInteger.ZERO;
            } else {
                ret = v > sum ? BigInteger.ZERO : rateEqual(pos + 1, sum - v);
            }
            valEqual3[pos][v][sum] = ret;
        }
        return valEqual3[pos][v][sum];
    }
    
    BigInteger[][] valRate2 = null;
    private BigInteger rate2(int[] rates) {
        int sum = Arrays.stream(rates).sum();
        valRate2 = new BigInteger[rates.length+1][sum+2];
        
        BigInteger total = rate2(0, rates, sum);
        return total;
    }
    
    private BigInteger rate2(int pos, int[] rates, int sum) {
        if (valRate2[pos][sum] == null) {
            BigInteger ret = BigInteger.ZERO;
            if (pos == rates.length) {
                ret = sum == 0 ? BigInteger.ONE : BigInteger.ZERO;
            } else {
                for (int s = 0; s < rates[pos]; s++) {
                    ret = ret.add(rateEqual(pos, s, sum));
                }
                
                ret = ret.add(rate2(pos + 1, rates, sum - rates[pos]));
            }
            valRate2[pos][sum] = ret;
        }
        return valRate2[pos][sum];
    }
}
