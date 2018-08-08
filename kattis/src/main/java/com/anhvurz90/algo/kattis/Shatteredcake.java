package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shatteredcake {

  public static void main(String[] args) {
    new Shatteredcake().run();
  }

  private void run() {
    try (BufferedReader br = 
            new BufferedReader(
                new InputStreamReader(System.in))) {
      Long w = Long.parseLong(br.readLine());
      int n = Integer.parseInt(br.readLine());
      Long total = 0L;
      for (int i = 0; i < n; i++) {
        String[] pair = br.readLine().split(" ");
        long a = Long.parseLong(pair[0]);
        long b = Long.parseLong(pair[1]);
        total+= a * b;
      }
      System.out.println(total / w);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
