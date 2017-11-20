package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Sortofsorting {

    public static void main(String[] args){
        new Sortofsorting().run();
    }
    
    private void run() {
        try(BufferedReader br =
            new BufferedReader(
                new InputStreamReader(System.in))) {
            int count = 0;
            while (true) {
                int n = Integer.parseInt(br.readLine());
                if (n == 0) {
                    break;
                }
                if (count ++ > 0) {
                    System.out.println();
                }
                List<String> arr = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    arr.add(br.readLine());
                }
                
                arr.sort((s, t) -> s.substring(0, 2).compareTo(t.substring(0, 2)));
                arr.forEach(s -> System.out.println(s));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
