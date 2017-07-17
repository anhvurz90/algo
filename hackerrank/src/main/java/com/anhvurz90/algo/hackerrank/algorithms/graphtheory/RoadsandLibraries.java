package com.anhvurz90.algo.hackerrank.algorithms.graphtheory;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RoadsandLibraries {
//public class Solution {
    
    private static boolean[] flags = null;
    private static List<Integer>[] connections = null;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = 
//                new Scanner(System.in);
                new Scanner(new File("RoadsandLibraries.in"));
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int cities = in.nextInt();
            int roads = in.nextInt();
            
            long libCost = in.nextLong();
            long roadCost = in.nextLong();
            
            flags = new boolean[cities];
            connections = new List[cities];
            
            for(int a1 = 0; a1 < roads; a1++){
                int city_1 = in.nextInt();
                int city_2 = in.nextInt();
                addConnection(city_1 - 1, city_2 - 1);
            }
            
            long ret = 0;
            
            for (int i = 0; i < cities; i++) {
                flags[i] = true;
            }
            
            for (int i = 0; i < cities; i++) {
                if (flags[i]) {
                    int count = spread(i);
                    ret += libCost + 1L * (count-1) * Math.min(libCost, roadCost);
//                    System.out.println("Count: " + count);
                }
            }
            
            System.out.println(ret);
        }
    }

    private static int spread(int i) {
//        System.out.println("Spread: " + i);
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        flags[i] = false;
        while (!queue.isEmpty()) {
            count ++;
            int city = queue.poll();
//            System.out.println("city: " + city);
            if (connections[city] != null) {
                for (int neighbor : connections[city]) {
                    if (flags[neighbor]) {
                        queue.add(neighbor);
                        flags[neighbor] = false;
                    }
                }
            }
        }
        return count;
    }

    private static void addConnection(int city1, int city2) {
//        System.out.println(connections.length);
//        System.out.println(city1 + " " + city2);
        if (connections[city1] == null) {
            connections[city1] = new LinkedList<>();
        }
        connections[city1].add(city2);
        
        if (connections[city2] == null) {
            connections[city2] = new LinkedList<>();
        }
        connections[city2].add(city1);
    }
}