package com.anhvurz90.algo.hackerrank.algorithms.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class HackerlandRadioTransmitters {

    int n = 0;
    int k = 0;
    Set<Integer> x = new TreeSet<>();
    boolean[] put;
    boolean[] covered;
    Integer[] pos;
    
    public static void main(String[] args) throws FileNotFoundException {
        new HackerlandRadioTransmitters().run();
    }
    
    public void run() throws FileNotFoundException {
        Scanner in = 
//                new Scanner(System.in);
                new Scanner(new File("HackerlandRadioTransmitters.in"));
        n = in.nextInt();
        k = in.nextInt();
        
        for(int x_i=0; x_i < n; x_i++){
            x.add(in.nextInt());
        }
        
        n = x.size();
        put = new boolean[n];
        covered = new boolean[n];
        
        pos = x.toArray(new Integer[]{});
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!covered[i]) {
                int r = findMaxRightToPut(i);
                put[r] = true;
                cover(r);
                count ++;
            }
        }
        System.out.println(count);
    }

     private void cover(int index) {
         int left = index;
         while (left >=0 && pos[index] - pos[left] <= k) {
             covered[left] = true;
             left --;
         }
         int right = index;
         while (right < n && pos[right] - pos[index] <= k) {
             covered[right] = true;
             right ++;
         }
    }

    int findMaxRightToPut(int index) {
        int ret = index;
        for (int i = index + 1; i < n; i++) {
            if (pos[i] - pos[index] <= k) {
                ret = i;
            }
        }
        return ret;
    }
}
