package com.anhvurz90.algo.codefights.challenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class WordBoggle {

  Set<String> suffixes = new HashSet<>();
  Set<String> wordSet = new HashSet<>();
  Set<String> result = new TreeSet<>();
  char[][] board;
  boolean[][] visited;
  
  String[] wordBoggle(char[][] board, String[] words) {
    buildSuffixes(words);
    buildWordSet(words);
    this.board = board;
    visited = new boolean[board.length][board[0].length];
    
    for (int a = 0; a < board.length; a++) {
      for (int b = 0; b < board[0].length; b++) {
        if (!visited[a][b]) {
          spead("", a, b);
        }
      }
    }
    
    return result.toArray(new String[] {});
  }
  
  private void buildSuffixes(String[] words) {
    for (String word: words) {
      for (int len = 1; len <= word.length(); len++) {
        suffixes.add(word.substring(0, len));
      }
    }
  }
  
  private void buildWordSet(String[] words) {
    wordSet.addAll(Arrays.asList(words));
  }
  
  private void spead(String st, int a, int b) {
    String currentSt = st + board[a][b];
    System.out.println(currentSt);
    if (wordSet.contains(currentSt)) {
      result.add(currentSt);
    }
    if (suffixes.contains(currentSt)) {
      visited[a][b] = true;
      
      for (int dx = -1; dx <= 1; dx++) {
        for (int dy = -1; dy <= 1; dy++) {
          if (okPos(a + dx, b + dy)) {
            spead(currentSt, a + dx, b + dy);
          }
        }
      }
      
      visited[a][b] = false;
    }
  }
  
  private boolean okPos(int a, int b) {
    return a >= 0 && a < board.length &&
           b >= 0 && b < board[0].length &&
           !visited[a][b];
  }
  
  
  static char[][] bb = new char[][] {{'R','L','D'}, 
                              {'U','O','E'}, 
                              {'C','S','O'}};
  static String[] ww = new String[] {"CODE", 
                              "SOLO", 
                              "RULES", 
                              "COOL"};                            
  public static void main(String[] args) {
    WordBoggle wb = new WordBoggle();
    wb.wordBoggle(bb, ww);
  }

}
