package com.anhvurz90.algo.kattis;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lindenmayorsystem {

  public static void main(String[] args) {
    new Lindenmayorsystem().run();
  }

  private void run() {
    Scanner sc = new Scanner(System.in);
    
    String[] pairs = sc.nextLine().split(" ");
    int ruleCount = Integer.parseInt(pairs[0]);
    int transformCount = Integer.parseInt(pairs[1]);
    
    Map<Character, String> rules = new HashMap<>();
    for (int ruleI = 0; ruleI < ruleCount; ruleI++) {
      String[] crules = sc.nextLine().split(" ");
      rules.put(crules[0].charAt(0), crules[2]);
    }
    
    String seq = sc.nextLine();
    for (int tI = 0; tI < transformCount; tI++) {
      StringBuilder s = new StringBuilder();
      for (char c : seq.toCharArray()) {
        if (rules.containsKey(c)) {
          s.append(rules.get(c));
        } else {
          s.append(c);
        }
      }
      seq = s.toString();
    }
    
    System.out.println(seq);
    sc.close();
  }
}
