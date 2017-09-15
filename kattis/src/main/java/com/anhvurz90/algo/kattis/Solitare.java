package com.anhvurz90.algo.kattis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Solitare {
    
    private static final char PEG  = 'o';
    private static final char EMPTY  = '.';
    
    private int[] xMoves = {0, 0, 1,-1};
    private int[] yMoves = {1,-1, 0, 0};

    public static void main(String[] args) {
        new Solitare().run();
    }
    
    private List<String> board;
    private int minPeg;
    private int minMove;
    private int row;
    private int col;
    
    private List<String> readBoard(Scanner sc) {
        List<String> ret = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.length() > 0) {
                ret.add(line);
            } else {
                break;
            }
        }
        row = ret.size();
        col = ret.get(0).length();
        return ret;
    }
    
    private void move() {
        Queue<List<String>> queue = new LinkedList<>();
        queue.add(board);
        Map<List<String>, Integer> map = new HashMap<>();
        map.put(board, 0);
        
        while (!queue.isEmpty()) {
            List<String> current = queue.poll();
            int count = map.get(current);
            updateResult(current, count);
            for (List<String> newState: allPossibleMove(current)) {
                if (!map.containsKey(newState)) {
                    map.put(newState, count + 1);
                    queue.add(newState);
                }
            }
        }
    }
    
    private List<List<String>> allPossibleMove(List<String> current) {
        List<List<String>> ret = new ArrayList<>();
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                if (current.get(x).charAt(y) == PEG) {
                    for (int direction = 0; direction < 4; direction++) {
                        if (inboard(x + xMoves[direction], y + yMoves[direction]) &&
                            inboard(x + 2 * xMoves[direction], y + 2 * yMoves[direction]) &&
                            current.get(x + xMoves[direction]).charAt(y + yMoves[direction]) == PEG &&
                            current.get(x + 2 * xMoves[direction]).charAt(y + 2 * yMoves[direction]) == EMPTY) {
                            char[][] newState = cloneToArr(current);
                            newState[x][y] = EMPTY;
                            newState[x + xMoves[direction]][y + yMoves[direction]] = EMPTY;
                            newState[x + 2 * xMoves[direction]][y + 2 * yMoves[direction]] = PEG;
                            ret.add(convertToList(newState));
                        }
                    }
                }
            }
        }
        
        return ret;
    }
    
    private boolean inboard(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
    
    private char[][] cloneToArr(List<String> state) {
        char[][] ret = new char[row][col];
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                ret[x][y] = state.get(x).charAt(y);
            }
        }
        return ret;
    }
    
    private List<String> convertToList(char[][] state) {
        List<String> ret = new ArrayList<>();
        for (char[] crow: state) {
            String line = "";
            for (char c : crow) {
                line+= c;
            }
            ret.add(line);
        }
        return ret;
    }

    private void updateResult(List<String> state, int count) {
        int pegNum = countPeg(state);
        if (pegNum < minPeg) {
            minPeg = pegNum;
            minMove =  count;
        } else if (pegNum == minPeg && count < minMove) {
            minMove = count;
        }
    }
    
    private int countPeg(List<String> state) {
        int ret = 0;
        for (String row : state) {
            for (char c: row.toCharArray()) {
                if (c == PEG) {
                    ret ++;
                }
            }
        }
        return ret;
    }
    
    private void run() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int testI = 0; testI < n; testI ++) {
            minPeg = 100;
            minMove = 100;
            board = readBoard(sc);
            move();
            System.out.format("%d %d\n", minPeg, minMove);
        }
        sc.close();
    }
}
