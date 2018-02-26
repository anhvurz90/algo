package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Guessinggame {

    public static void main(String[] args) throws Exception {
        new Guessinggame().run();
    }
    
    private void run() throws Exception {
        BufferedReader br 
            = new BufferedReader(
                    new InputStreamReader(System.in));
        
        boolean stop = false;
        while(!stop) {
            boolean finishThisGame = false;
            boolean[] flag = new boolean[10];
            boolean noCheat = true;
            Arrays.fill(flag, true);
            while (!finishThisGame) {
                int num = Integer.parseInt(br.readLine());
                if (num == 0) {
                    stop = true;
                    break;
                }
                String guess = br.readLine();
                if ("too high".equals(guess)) {
                    for (int i = num-1; i < 10; i++) {
                        flag[i] = false;
                    }
                }
                if ("too low".equals(guess)) {
                    for (int i = 0; i < num; i++) {
                        flag[i] = false;
                    }
                }
                if ("right on".equals(guess)) {
                    noCheat = flag[num-1];
                    finishThisGame = true;
                }
            }
            if (!stop) {
                System.out.println(noCheat? "Stan may be honest" : 
                                             "Stan is dishonest");
            }
        }
        br.close();
    }
}
