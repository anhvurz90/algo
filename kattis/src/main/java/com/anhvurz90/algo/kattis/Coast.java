package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Coast {

    public static void main(String[] args) throws IOException {
        new Coast().run();
    }
    
    private static final char FENCE = '2';
    private static final char PASSED = '3';
    private static final char WATER = '0';
    private static final char LAND = '1';
    
    private static final int[] dx = new int[] {-1, 1, 0, 0};
    private static final int[] dy = new int[] { 0, 0,-1, 1};
    
    private int row;
    private int col;
    private List<StringBuilder> map;
    private void run() throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String[] pair = br.readLine().split(" ");
        row = Integer.parseInt(pair[0]);
        col = Integer.parseInt(pair[1]);
        map = new ArrayList<>();
        map.add(createString(FENCE, col + 4));
        map.add(new StringBuilder().append(FENCE).append(createString(WATER, col + 2)).append(FENCE));
        
        for (int i = 0; i < row; i++) {
            String r = br.readLine();
            map.add(new StringBuilder().append(FENCE).append(WATER).append(r).append(WATER).append(FENCE));
        }
        
        map.add(new StringBuilder().append(FENCE).append(createString(WATER, col + 2)).append(FENCE));
        map.add(createString(FENCE, col + 4));
        br.close();
        
//        print(map); 

        spread(map);
//        print(map);

        int count = 0;
        for(int x = 1; x < row + 4; x++) {
            for(int y = 1; y < col + 4; y++) {
                if (map.get(x).charAt(y) == LAND) {
                    for (int d = 0; d < dx.length; d++) {
                        if (map.get(x + dx[d]).charAt(y + dy[d]) == PASSED) {
                            count ++;
                        }
                    }
                }
            }
        }
        
        System.out.println(count);
    }
    
    private void print(List<StringBuilder> map) {
        System.out.println();
        for (StringBuilder sb: map) {
            System.out.println(sb);
        }
    }

    private void spread(List<StringBuilder> map) {
        for(int x = 1; x < row + 4; x++) {
            if (map.get(x).charAt(1) == WATER) {
                spread(map, x, 1);
            }
            if (map.get(x).charAt(col + 2) == WATER) {
                spread(map, x, col + 2);
            }
        }
        for(int y = 1; y < col + 4; y++) {
            if (map.get(1).charAt(y) == WATER) {
                spread(map, 1, y);
            }
            if (map.get(row + 2).charAt(y) == WATER) {
                spread(map, row + 2, y);
            }
            
        }
    }
    
    private void spread(List<StringBuilder> map, int x, int y) {
//        System.out.println();
        Pair p = new Pair(x, y);
        Queue<Pair> q = new LinkedList<>();
        q.add(p);
        map.get(x).setCharAt(y, PASSED);
        while (!q.isEmpty()) {
            Pair current = q.poll();
//            System.out.println(current.x + "; " + current.y);
            for (int i = 0; i < dx.length; i++) {
                if (map.get(current.x + dx[i]).charAt(current.y + dy[i]) == WATER) {
                    q.add(new Pair(current.x + dx[i], current.y + dy[i]));
                    map.get(current.x + dx[i]).setCharAt(current.y + dy[i], PASSED);
                }
            }
        }
//        print(map);
    }

    private StringBuilder createString(char c, int len) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < len; i++) {
            s.append(c);
        }
        return s;
    }
    
    class Pair {
        int x, y;

        public Pair(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }
}
