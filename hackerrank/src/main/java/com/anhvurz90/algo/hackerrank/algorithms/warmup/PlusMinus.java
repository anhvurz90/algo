package com.anhvurz90.algo.hackerrank.algorithms.warmup;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PlusMinus {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        
        int p = 0, ne = 0, z = 0;
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
            if (arr[arr_i] > 0) { p ++; }
            else if (arr[arr_i] < 0) { ne ++; }
            else { z ++; }
        }
        
        System.out.println(p * 1.0 / n);
        System.out.println(ne * 1.0 / n);
        System.out.println(z * 1.0 / n);
    }
}
