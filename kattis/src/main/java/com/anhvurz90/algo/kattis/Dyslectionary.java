package com.anhvurz90.algo.kattis;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Dyslectionary {

    public static void main(String[] args) throws Exception {
        new Dyslectionary().run();
    }
    
    private List<String> spaces = new ArrayList<>();
    
    private void run() throws Exception {
        spaces.add("");
        Scanner sc = new Scanner(System.in);
//                        new File("Dys.inp"));
        List<String> words = new ArrayList<>();
        while (sc.hasNextLine()) {
            String word = sc.nextLine();
            if (!word.isEmpty()) {
                words.add(word);
            } else {
                print(words);
                System.out.println();
                words.clear();
            }
        }
        print(words);
        sc.close();
    }
    
    private void print(List<String> words) {
        int maxLen = 0;
        for (String word: words) {
            maxLen = Math.max(maxLen, word.length());
        }
        
        while (spaces.size() < maxLen) {
            spaces.add(spaces.get(spaces.size() - 1) + " ");
        }
        
        
        List<String> reversedWords = 
            words.stream()
                 .map(word -> new StringBuilder(word).reverse().toString())
                 .collect(Collectors.toList());
        reversedWords.sort((w1, w2) -> w1.compareTo(w2));
        for (String word: reversedWords) {
            System.out.print(spaces.get(maxLen - word.length()));
            System.out.println(new StringBuilder(word).reverse());
        };
    }
}
