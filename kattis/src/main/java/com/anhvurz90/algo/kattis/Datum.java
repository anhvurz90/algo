package com.anhvurz90.algo.kattis;

import java.util.Calendar;
import java.util.Scanner;

public class Datum {

    private static final String[] words = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    
    public static void main(String[] args) {
        new Datum().run();
    }
    
    private void run() {
        Scanner sc = new Scanner(System.in);
        int day = sc.nextInt();
        int month = sc.nextInt();
        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(2009, month-1, day);
        int ret = c.get(Calendar.DAY_OF_WEEK);
        System.out.println(words[ret-1]);
        sc.close();
    }
}
