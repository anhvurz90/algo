package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Guessthedatastructure {

    public static void main(String[] args) throws IOException {
        new Guessthedatastructure().run();
    }

    private void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = br.readLine()) != null) {
            int operationSize = Integer.parseInt(line);
            Queue<Integer> q = new LinkedList<>();
            int correctQ = 0;
            Stack<Integer> s = new Stack<>();
            int correctS = 0;
            Queue<Integer> p = new PriorityQueue<>(Comparator.reverseOrder());
            int correctP = 0;
            
            int take = 0;
            for (int i = 0; i < operationSize; i++) {
                String[] pair = br.readLine().split(" ");
                int cType = Integer.parseInt(pair[0]);
                int cVal = Integer.parseInt(pair[1]);
                if (cType == 1) {
                    q.add(cVal);
                    s.push(cVal);
                    p.add(cVal);
                } else if (cType == 2) {
                    take++;
                    int qVal = -1;
                    try { qVal = q.poll(); } catch (Exception e) {}
                    if (qVal == cVal) correctQ++;
                    
                    int sVal = -1;
                    try { sVal = s.pop(); } catch (Exception e) {}
                    if (sVal == cVal) correctS++;
                    
                    int pVal = -1;
                    try { pVal = p.poll(); } catch (Exception e) {}
                    if (pVal == cVal) correctP++;
                }
            }
            
            int count = 0;
            if (correctQ == take) count ++;
            if (correctS == take) count ++;
            if (correctP == take) count ++;
            if (count == 0) {
                System.out.println("impossible");
            } else if (count > 1) {
                System.out.println("not sure");
            } else {
                if (correctQ == take) System.out.println("queue");
                if (correctS == take) System.out.println("stack");
                if (correctP == take) System.out.println("priority queue");
            }
        }
        br.close();
    }
}
