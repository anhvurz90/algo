package com.anhvurz90.algo.kattis;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class PrimeSieve {

    private int n, q;
    private Set<Integer> queries;
    private byte[] bit;
    
    private int primeCount;
    
    public static void main(String[] args) {
        new PrimeSieve().run();
    }

    private void run() {
        readInput();
        sievePrimes();
        writeOutput();
    }
    
    private void readInput() {
        Scanner sc = new Scanner(System.in);
//      new Scanner(new File("PriveSieve.inp"));
        n = sc.nextInt();
        q = sc.nextInt();
        queries = new LinkedHashSet<>();
        for (int i = 0; i < q; i++) {
            queries.add(sc.nextInt());
        }
        sc.close();
    }

    private void sievePrimes() {
        bit = new byte[n / 8 + 1];
        setPrime(0, 1);
        setPrime(1, 1);
        for (int a = 2; a*a <= n; a++) {
            if (isPrime(a)) {
                for (int b = 2; b * a <= n; b++) {
                    setPrime(b * a, 1);
                }
            }
        }
        primeCount = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primeCount ++;
            }
        }
    }
    
    private void setPrime(int i, int val) {
        int bucket = i / 8;
        int offset = i % 8;
        if (val == 1) {
            bit[bucket] |= 1<<offset;
        } else {
            bit[bucket] &= ~(1<<offset);
        }
    }
    
    private boolean isPrime(int i) {
        int bucket = i / 8;
        int offset = i % 8;
        return (bit[bucket] & (1<<offset)) == 0; 
    }

    private void writeOutput() {
        System.out.println(primeCount);
        for (int query : queries) {
            System.out.println(isPrime(query) ? 1 : 0);
        }
    }

}
