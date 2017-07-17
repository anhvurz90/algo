package com.anhvurz90.algo.hackerrank.algorithms.strings;

import java.util.Scanner;

public class SuperReducedString {

    static String super_reduced_string(String s){
        StringBuilder str = new StringBuilder(s);
        boolean stop = true;
        do {
            stop = true;
            for (int i = 0; i < str.length() -1; i++) {
                if (str.charAt(i) == str.charAt(i + 1)) {
                    str = str.deleteCharAt(i);
                    str = str.deleteCharAt(i);
                    stop = false;
                    break;
                }
            }
        } while (!stop);
        
        return str.length() > 0 ? str.toString() : "Empty String";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
//        String s = "aa";
        String result = super_reduced_string(s);
        System.out.println(result);
    }}
