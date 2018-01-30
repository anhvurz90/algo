package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Anothercandies {

    public static void main(String[] args) throws IOException {
        new Anothercandies().run();
    }

    private void run() throws IOException{
        BufferedReader br = 
            new BufferedReader(
                new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < testCount; i++) {
            br.readLine();
            int childCount = Integer.parseInt(br.readLine());
            
            BigInteger sum = BigInteger.ZERO;
            for (int child = 0; child < childCount; child++) {
                String val = br.readLine();
                sum = sum.add(new BigInteger(val));
            }
            
            System.out.println(
                sum.remainder(BigInteger.valueOf(childCount + 0L)).equals(BigInteger.ZERO) ?
                "YES" : "NO");
        }
        br.close();
    }
}
