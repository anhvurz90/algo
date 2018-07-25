package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Conversationlog {

  public static void main(String[] args) {
    new Conversationlog().run();
  }

  private void run() {
    Map<String, Set<String>> userWords = new HashMap<>();
    Map<String, Integer> wordCounts = new HashMap<>();
    
    try (BufferedReader br = 
          new BufferedReader(
            new InputStreamReader(System.in));
         PrintWriter pr = 
           new PrintWriter(
             new BufferedWriter(
               new OutputStreamWriter(System.out)))){
      
      int n = Integer.parseInt(br.readLine());
      for (int chatI = 0; chatI < n; chatI++) {
        String conversation = br.readLine();
        int idx = conversation.indexOf(" ");
        if (idx != -1) {
          String user = conversation.substring(0, idx);
          String words = conversation.substring(idx + 1);
          
          //
          if (!userWords.containsKey(user)) {
            userWords.put(user, new HashSet<>());
          }
          userWords.get(user).addAll(Arrays.asList(words.split(" ")));
          //
          for (String word : words.split(" ")) {
            int oldCount = wordCounts.containsKey(word) ? wordCounts.get(word) : 0;
            wordCounts.put(word, oldCount + 1);
          }
        }
      }
      br.close();
      
      Set<String> commonWords = userWords.values().iterator().next();
      for (Set<String> words : userWords.values()) {
        commonWords.retainAll(words);
      }
      
      if (commonWords.isEmpty()) {
        pr.println("ALL CLEAR");
      } else {
        Set<WordCounts> wcs = new TreeSet<>();
        for (String word : commonWords) {
          wcs.add(new WordCounts(word, wordCounts.get(word)));
        }
        
        for (WordCounts wc: wcs) {
          pr.println(wc.word);
        }
      }
      pr.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  class WordCounts implements Comparable<WordCounts> {

    String word;
    int count;
    
    public WordCounts(String word, int count) {
      this.word = word;
      this.count = count;
    }
    
    @Override
    public int compareTo(WordCounts o) {
      return count != o.count ? o.count - count:
                                word.compareTo(o.word);
    }

  }
}
