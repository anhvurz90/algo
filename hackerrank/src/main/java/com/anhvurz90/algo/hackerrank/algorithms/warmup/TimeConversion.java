package com.anhvurz90.algo.hackerrank.algorithms.warmup;
import java.io.*;
import java.util.*;

public class TimeConversion {

    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        new TimeConversion().convertTime();
    }
    
    private void convertTime() throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        String time = input.substring(0, 8);
        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0]);
        
        String suffix = input.substring(8);
        if ("PM".equals(suffix)) {
            if (hour < 12) {
                hour += 12;
            }
        } else if (hour == 12) {
            hour = 0;
        }
        
        System.out.println((hour < 10 ? "0" : "") + hour + ":" + times[1] + ":" + times[2]);
    }
}