package com.anhvurz90.algo.kattis;

import java.util.Scanner;

public class Backspace {

    public static void main(String[] args) {
        new Backspace().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        StringBuilder sb = new StringBuilder(inp.length());
        for (int inpI = 0; inpI < inp.length(); inpI++) {
            char c = inp.charAt(inpI);
            if (c == '<') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        sc.close();
        
        System.out.println(sb);
    }
}
