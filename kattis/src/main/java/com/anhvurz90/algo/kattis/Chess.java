package com.anhvurz90.algo.kattis;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Chess {
    
    private static final int SIZE = 8;

    public static void main(String[] args) throws Exception {
        new Chess().run();
    }
    
    private void run() throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String pos = sc.nextLine();
//            System.out.println(pos);
            Location src = new Location();
            src.col = pos.charAt(0);
            src.row = pos.charAt(2) - '0';
            
            Location des = new Location();
            des.col = pos.charAt(4);
            des.row = pos.charAt(6) - '0';
            
            findWay(src, des);
        }
        sc.close();
    }
    
    private void findWay(Location src, Location des) {
        boolean[][] board = new boolean[SIZE][SIZE];
        Queue<Location> queue = new LinkedList<>();
        queue.add(src);
        board[src.col-'A'][src.row-1] = true;
        boolean found = false;
        while (!queue.isEmpty()) {
            Location current = queue.poll();
//            System.out.println(current);
            if (current.col == des.col && current.row == des.row) {
                printWay(current);
                found = true;
                break;
            }
            List<Location> moves = moveFrom(current);
            for (Location move: moves) {
                if (!board[move.col - 'A'][move.row - 1]) {
                    move.count = current.count + 1;
                    move.prev = current;
                    queue.add(move);
                    board[move.col - 'A'][move.row - 1] = true;
                }
            }
        }
        if (!found) {
            System.out.println("Impossible");
        }
    }
    
    private List<Location> moveFrom(Location current) {
        List<Location> ret = new ArrayList<>();
        
        for (char col = 'A'; col <= 'A' + SIZE - 1; col++) {
            int row = - col + current.col + current.row;
//            System.out.println(col + "+" + row);
            if (row > 0 && row <= SIZE) {
                Location l = new Location();
                l.col = col;
                l.row = row;
                ret.add(l);
            }
        }
        
        for (int row = 1; row <= SIZE; row++) {
            char col = (char)(row - current.row + current.col);
//            System.out.println(col + "-" + row);
            if (col >= 'A'  && col < 'A' + SIZE) {
                Location l = new Location();
                l.col = col;
                l.row = row;
                ret.add(l);
            }
        }

        return ret;
    }

    private void printWay(Location des) {
        System.out.print(des.count + " ");
        Stack<Location> way = new Stack<>();
        while (des!= null) {
            way.push(des);
            des = des.prev;
        }
        StringBuilder sb = new StringBuilder();
        while (!way.isEmpty()) {
            Location current = way.pop();
            sb.append(current.col)
              .append(" ")
              .append(current.row)
              .append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
    
    class Location {
        char col;
        int row;
        int count;
        Location prev;
        @Override
        public String toString() {
            return "Location [col=" + col + ", row=" + row + ", count=" + count + ", prev=" + prev + "]";
        }
        
    }
}
