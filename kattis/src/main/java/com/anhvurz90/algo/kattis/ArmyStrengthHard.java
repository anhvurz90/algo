package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArmyStrengthHard {

    public static void main(String[] args) throws NumberFormatException, IOException {
        new ArmyStrengthHard().run();
    }
    
    private void run() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(
                                new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < testCaseCount; testCase++) {
            br.readLine();
            String[] pair = br.readLine().split(" ");
            int g = Integer.parseInt(pair[0]);
            int m = Integer.parseInt(pair[1]);
            
            int maxG = 0;
            String gSt = br.readLine();
            StringBuilder val = new StringBuilder();
            for (int i = 0; i < gSt.length(); i++) {
                char c = gSt.charAt(i);
                if (c != ' ') {
                    val.append(c);
                } else {
                    maxG = Math.max(maxG, Integer.parseInt(val.toString()));
                    val = new StringBuilder();
                }
            }
            maxG = Math.max(maxG, Integer.parseInt(val.toString()));
            
            int maxM = 0;
            String mSt = br.readLine();
            val = new StringBuilder();
            for (int i = 0; i < mSt.length(); i++) {
                char c = mSt.charAt(i);
                if (c != ' ') {
                    val.append(c);
                } else {
                    maxM = Math.max(maxM, Integer.parseInt(val.toString()));
                    val = new StringBuilder();
                }
            }
            maxM = Math.max(maxM, Integer.parseInt(val.toString()));
            
            System.out.println(maxM > maxG ? "MechaGodzilla" : "Godzilla");
        }
        br.close();
    }
}
