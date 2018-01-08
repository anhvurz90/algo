package com.anhvurz90.algo.kattis;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Esej {

    public static void main(String[] args) throws Exception {
        new Esej().run();
    }
    
    private void run() throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        int c = a == b ? a : Math.max(a, (int)Math.ceil(b / 2));
        List<String> s1 = Arrays.asList(new String[]{""});
        int count = 0;
        while (count < c) {
            count = 0;
            List<String> s2 = new ArrayList<>();
            for (String s: s1) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    s2.add(s + ch);
                    count++;
                    if (count >= c) {
                        break;
                    }
                }
                if (count >= c) {
                    break;
                }
            }
            s1 = s2;
        }
        PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        for (int i = 0; i < s1.size() -1; i++) {
            pr.print(s1.get(i));
            pr.print(" ");
        }
        pr.print(s1.get(s1.size() - 1));
        pr.close();
    }
}
