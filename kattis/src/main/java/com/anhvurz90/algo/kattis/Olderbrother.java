package com.anhvurz90.algo.kattis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Olderbrother {

    public static void main(String[] args) {
        new Olderbrother().run();
    }
    
    private List<Integer> primes = new ArrayList<>();
    
    private void run() {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 2; i < Math.sqrt(q) + 2; i++) {
            if (isPrime(i)) {
                primes.add(i);
                if (ok(i, q)) {
                    System.out.println("yes");
                    return;
                }
            }
        }
        System.out.println(isPrime(q) ? "yes" : "no");
    }
    
    private boolean ok(int prime, int q) {
        if (q < prime) {
            return false;
        }
        while (q % prime == 0) {
            q/= prime;
        }
        return q == 1;
    }
    
    private boolean isPrime(int i) {
        if (i < 2) {
            return false;
        }
        for (int p : primes) {
            if (i == p) {
                return true;
            }
            if (i % p == 0) {
                return false;
            }
        }
        return true;
    }
}
