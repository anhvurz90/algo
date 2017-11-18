package com.anhvurz90.algo.kattis;

import java.util.Scanner;

public class Bitbybit {

    private static final char QUES = '?';
    private static final char ONE = '1';
    private static final char ZERO = '0';
    
    public static void main(String[] args) {
        new Bitbybit().run();
    }
    
    private void run() {
        Scanner sc = new Scanner(System.in);
        boolean stop = false;
        do {
            int instructionCount = Integer.parseInt(sc.nextLine());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 32; i++) {
                sb.append(QUES);
            }
            for (int i = 0; i < instructionCount; i++) {
                String command = sc.nextLine();
                if (command.startsWith("SET")) {
                    int pos = Integer.parseInt(command.split(" ")[1]);
                    sb.setCharAt(pos, ONE);
                }
                if (command.startsWith("CLEAR")) {
                    int pos = Integer.parseInt(command.split(" ")[1]);
                    sb.setCharAt(pos, ZERO);
                }
                if (command.startsWith("AND")) {
                    int pos1 = Integer.parseInt(command.split(" ")[1]);
                    int pos2 = Integer.parseInt(command.split(" ")[2]);
                    if (sb.charAt(pos1) == ZERO || sb.charAt(pos2) == ZERO) {
                        sb.setCharAt(pos1, ZERO);
                    } else if (sb.charAt(pos1) == QUES || sb.charAt(pos2) == QUES) {
                        sb.setCharAt(pos1, QUES);
                    } else {
                        sb.setCharAt(pos1, ONE);
                    }
                }
                if (command.startsWith("OR")) {
                    int pos1 = Integer.parseInt(command.split(" ")[1]);
                    int pos2 = Integer.parseInt(command.split(" ")[2]);
                    if (sb.charAt(pos1) == ONE || sb.charAt(pos2) == ONE) {
                        sb.setCharAt(pos1, ONE);
                    } else if (sb.charAt(pos1) == QUES || sb.charAt(pos2) == QUES) {
                        sb.setCharAt(pos1, QUES);
                    } else {
                        sb.setCharAt(pos1, ZERO);
                    }
                }
            }
            stop = instructionCount == 0;
            if (!stop) {
                System.out.println(sb.reverse());
            }
        } while (!stop);
        sc.close();
    }
}
