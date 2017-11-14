package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Holeynqueensbatman {

    public static void main(String[] args) throws Exception {
        new Holeynqueensbatman().run();
    }
    
    private void run() throws Exception {
        BufferedReader br = 
                new BufferedReader(
                        new InputStreamReader(System.in));
        String line = "";
        while (!"0 0".equals(line = br.readLine())) {
            Pair nm = createPair(line);
            List<Pair> holes = new ArrayList<>();
            for (int i = 0; i < nm.right; i++) {
                holes.add(createPair(br.readLine()));
            }
            System.out.println(count(nm.left, holes));
        }
        br.close();
    }

    private Pair createPair(String st) {
        String[] sts = st.split(" ");
        return new Pair(Integer.parseInt(sts[0]), Integer.parseInt(sts[1]));
    }
    
    private static final int EMPTY = 0;
    private static final int QUEEN = 1;
    private static final int HOLE = 2;
    
    private int[][] board;
    private boolean[] cols;
    private boolean[] diag1;
    private boolean[] diag2;
    private int n;
    private int total;
    
    private int count(int size, List<Pair> holes) {
        board = new int[size][size];
        cols = new boolean[size];
        diag1 = new boolean[size * 2];
        diag2 = new boolean[size * 2];
        n = size;
        total = 0;
        
        for (Pair h : holes) {
            board[h.left][h.right] = HOLE;
        }
        
        tri(0);
        return total;
    }
    
    private void tri(int row) {
        if (row == n) {
            total ++;
            return;
        }
        for (int c = 0; c < n; c++) {
            if (board[row][c] == EMPTY && !cols[c] && !diag1[row + c] && !diag2[row - c + n]) {
                cols[c] = true;
                diag1[row + c] = true;
                diag2[row - c + n] = true;
                tri(row + 1);
                cols[c] = false;
                diag1[row + c] = false;
                diag2[row - c + n] = false;
            }
        }
    }
    
    class Pair {
        int left;
        int right;
        public Pair(int left, int right) {
            super();
            this.left = left;
            this.right = right;
        }
    }
}
