package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ones {

    public static void main(String[] args) throws IOException {
        new Ones().run();
    }
    
    private void run() throws IOException {
        BufferedReader br
            = new BufferedReader(
                    new InputStreamReader(System.in));
        
        String line;
        while ((line = br.readLine()) != null) {
            Long n = Long.parseLong(line);
            Long s = 1L;
            int len = 1;
            while (s % n != 0) {
                len ++;
                s = s * 10 + 1;
                s = s % n;
            }
            System.out.println(len);
        }
        br.close();
    }
}
