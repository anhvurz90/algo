package com.anhvurz90.algo.kattis;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bits {

    public static void main(String[] args) {
        new Bits().run();
    }
    
    private void run() {
        Scanner sc = new Scanner(System.in);
        int testNum = sc.nextInt();
        Map<Integer, Integer> cache = new HashMap<>(); 
        for (int iTest = 0; iTest < testNum; iTest++) {
            int x = sc.nextInt();
            if (!cache.containsKey(x)) {
                int count = getOneBits(x);
                cache.put(x,  count);
            }
            System.out.println(cache.get(x));
        }
        sc.close();
    }
    
    private int getOneBits(int x) {
        int ret = 0;
        while (x > 0) {
            String bits = Integer.toBinaryString(x);
            ret = Math.max(ret, countOnes(bits));
            x = x / 10;
        }
        return ret;
    }

    private int countOnes(String bits) {
        int count = 0;
        for (char c: bits.toCharArray()) {
            if (c == '1') {
                count ++;
            }
        }
        return count;
    }
}
