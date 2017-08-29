//package com.anhvurz90.algo.kattis;

import java.util.Scanner;

public class Two048 {
    
    private static final int size = 4;
    //left, up, right, down
    private static final int[] moveDeltaX = {0, -1, 0, 1};
    private static final int[] moveDeltaY = {-1, 0, 1, 0};

    public static void main(String[] args) {
        new Two048().run();
    }

    private Cell[][] cells = new Cell[size][size];
    private int move;
    
    private void run() {
        readInput();
        moveCells();
        writeOutput();
    }
    
    private void writeOutput() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(cells[row][col].val + (col < size-1 ? " " : "\n"));
            }
        }
    }

    private void readInput() {
        Scanner sc = new Scanner(System.in);
//      new Scanner(new File("Two048.inp"));

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                cells[row][col] = new Cell();
                cells[row][col].val = sc.nextInt();
            }
        }
        move = sc.nextInt();
        sc.close();
    }
    
    private void moveCells() {
        boolean act = false;
        do {
            boolean[][] acted = new boolean[size][size];
            act = false;
            //check move
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    if (cells[row][col].val != 0 && !acted[row][col]) {
                        int nextRow = row + moveDeltaX[move];
                        int nextCol = col + moveDeltaY[move];
                        if (canMove(nextRow, nextCol)) {
                            cells[nextRow][nextCol] = cells[row][col].clone();
                            cells[row][col] = new Cell();
                            act = true;
                            acted[nextRow][nextCol] = true;
                        }
                    }
                }
            }
            
            //check merge
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    if (cells[row][col].val != 0 && !acted[row][col]) {
                        int nextRow = row + moveDeltaX[move];
                        int nextCol = col + moveDeltaY[move];
                        if (canMerge(row, col, nextRow, nextCol)) {
                            cells[nextRow][nextCol].val += cells[row][col].val;
                            cells[nextRow][nextCol].merged = true;
                            cells[row][col] = new Cell();
                            act = true;
                            acted[nextRow][nextCol] = true;
                        }
                    }
                }
            }
        } while (act);
    }

    private boolean canMove(int nextRow, int nextCol) {
        return (nextRow >= 0) && (nextRow < size) &&
               (nextCol >= 0) && (nextCol < size) &&
               (cells[nextRow][nextCol].val == 0);
    }

    private boolean canMerge(int row, int col, int nextRow, int nextCol) {
        return (nextRow >= 0) && (nextRow < size) &&
                (nextCol >= 0) && (nextCol < size) &&
                (cells[row][col].merged == false) &&
                (cells[nextRow][nextCol].merged == false) &&
                (cells[nextRow][nextCol].val == cells[row][col].val);
    }

    class Cell {
        int val;
        boolean merged;
        
        @Override
        public Cell clone() {
            Cell ret = new Cell();
            ret.val = this.val;
            ret.merged = this.merged;
            return ret;
        }
    }
}
