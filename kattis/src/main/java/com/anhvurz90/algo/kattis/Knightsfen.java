package com.anhvurz90.algo.kattis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Knightsfen {

    private static final int size = 5;
    private static final int[] x = new int[] {-2,-2,-1, 1, 2, 2, 1,-1};
    private static final int[] y = new int[] {-1, 1,-2,-2,-1, 1, 2, 2};
    private String[] finalState;
    
    public static void main(String[] args) throws Exception {
        new Knightsfen().run();
    }
    
    private void run() throws Exception {
        createFinalState();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < n; i++) {
            String[] input = readInput(sc);
            int moves = countMove(input);
            if (moves > 10) {
                System.out.println("Unsolvable in less than 11 move(s).");
            } else {
                System.out.format("Solvable in %d move(s).\n", moves);
            }
        }
        
        sc.close();
    }
    
    private void createFinalState() {
        finalState = new String[] 
                {"11111",
                 "01111",
                 "00 11",
                 "00001",
                 "00000",
                };
        
    }
    
    private String[] readInput(Scanner sc) {
        String[] ret = new String[size];
        for (int i = 0; i < size; i++) {
            ret[i] = sc.nextLine();
        }
        return ret;
    }
    
    private int countMove(String[] input) {
        String stFinal = toString(finalState);
        
        Queue<String> queue = new LinkedList<>();
        queue.add(toString(input));
        
        Map<String, Integer> moves = new HashMap<>();
        moves.put(toString(input), 0);
        
        int maxStep = 0;
        while (!queue.isEmpty()) {
            String current = queue.poll();
            Integer step = moves.get(current);
            if (step > 10) {
                return step;
            }
            if (current.equals(stFinal)) {
                return step;
            }
            if (step == 10) {
                return step + 1;
            }
            
            maxStep = Math.max(maxStep, step);
            
            for (String move: allMoves(current)) {
                if (!moves.containsKey(move)) {
                    queue.add(move);
                    moves.put(move, step + 1);
                    if (move.equals(stFinal)) {
                        return step + 1;
                    }
                }
            }
        }
        return 12;
    }
    
    private String toString(String[] state) {
        String ret = "";
        for (String row: state) {
            ret+= row;
        }
        
        return ret;
    }
    
    private List<String> allMoves(String state) {
        List<String> ret = new ArrayList<>();
        
        int index = state.indexOf(' ');
        int a = index / size;
        int b = index % size;
        for (int i = 0; i < x.length; i++) {
            if (ok(a + x[i], b + y[i])) {
                ret.add(move(state, a, b, a + x[i], b + y[i]));
            }
        }
        return ret;
    }
    
    private boolean ok(int x, int y) {
        return x >= 0 && y >= 0 && x < size && y < size;
    }
    
    private String move(String state, int a, int b, int x, int y) {
        StringBuilder newState = new StringBuilder(state);
    
        char tmp = newState.charAt(a * size + b);
        newState.setCharAt(a * size + b, newState.charAt(x * size + y));
        newState.setCharAt(x * size + y, tmp);
        
        return newState.toString();
    }
}
