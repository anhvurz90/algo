//package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AveragesHard {

    public static void main(String[] args) throws Exception {
        new AveragesHard().run();
    }
    
    private void run() throws Exception {
        BufferedReader br =
            new BufferedReader(
                new InputStreamReader(System.in));

        int nTest = Integer.parseInt(br.readLine());
        for (int iTest = 0; iTest < nTest; iTest ++) {
            br.readLine();
            String[] pair = br.readLine().split(" ");
            int nCS = Integer.parseInt(pair[0]);
            int nE = Integer.parseInt(pair[1]);
            
            List<Integer> vals = new ArrayList<>(nCS + nE);
            while (vals.size() < nCS + nE) {
                String[] stVals = br.readLine().split(" ");
                vals.addAll(
                    Arrays.stream(stVals)
                          .map(s -> Integer.parseInt(s))
                          .collect(Collectors.toList()));
            }
            
            long sumCS = 0;
            for (int i = 0; i < nCS; i++) {
                sumCS += vals.get(i);
            }
            long sumE = 0;
            for (int i = 0; i < nE; i++) {
                sumE += vals.get(i + nCS);
            }
            
            double avgCS = sumCS * 1.0 / nCS;
            double avgE = sumE * 1.0 / nE;
            
            int countCS = 0;
            for (int i = 0; i < nCS; i++) {
                if (vals.get(i) < avgCS && vals.get(i) > avgE) {
                    countCS++;
                }
            }
            
            System.out.println(countCS);
        }
        br.close();
    }
    
}
