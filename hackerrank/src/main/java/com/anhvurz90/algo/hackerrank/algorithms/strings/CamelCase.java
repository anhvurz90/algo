package com.anhvurz90.algo.hackerrank.algorithms.strings;

import java.util.Scanner;

public class CamelCase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                count ++;
            }
        }
        System.out.println(count + 1);
        in.close();
    }
    
}
