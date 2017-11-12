package com.anhvurz90.algo.kattis;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Anagramcounting {

    public static void main(String[] args) {
        new Anagramcounting().run();
    }
    
    private Map<Integer, BigInteger> m = new HashMap<>();
    private void run() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String st = sc.nextLine();
            Map<Character, Integer> map = new HashMap<>();
            for (char c : st.toCharArray()) {
                Integer old = map.get(c);
                map.put(c, old == null ? 1 : old + 1);
            }
            BigInteger ret = gt(st.length());
            for (Entry<Character, Integer> e: map.entrySet()) {
                ret = ret.divide(gt(e.getValue()));
            }
            System.out.println(ret);
        }
        sc.close();
    }
    
    private BigInteger gt(int n) {
        if (m.containsKey(n)) {
            return m.get(n);
        }
        BigInteger ret = BigInteger.ONE;
        for (int i = 2; i<= n; i++) {
            ret = ret.multiply(BigInteger.valueOf(i));
        }
        
        m.put(n, ret);
        return ret;
    }
}
