package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jollyjumpers {

  public static void main(String[] args) {
    new Jollyjumpers().run();
  }

  private void run() {
    try (BufferedReader br = 
          new BufferedReader(
            new InputStreamReader(System.in))) {
      String line;
      while ((line = br.readLine()) != null) {
        boolean jolly = true;
        String[] stNums = line.split(" ");
        int n = Integer.parseInt(stNums[0]);
        if (n > 0) {
          int[] count = new int[n];
          int prev = Integer.parseInt(stNums[1]);
          for (int i = 2; i < n; i++) {
            int current = Integer.parseInt(stNums[i]);
            int diff = Math.abs(current - prev);
            if (diff < 1 || diff >= n || count[diff] != 0) {
              jolly = false;
              break;
            }
            count[diff] = 1;
            prev = current;
          }
        }
        System.out.println(jolly ? "Jolly" : "Not jolly");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
