package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CompoundWords {

	public static void main(String[] args) {
		new CompoundWords().run();
	}

	private void run() {
		List<String> words = readWords();
		Set<String> cWordSet = new TreeSet<>();
		for (int outerIdx = 0; outerIdx < words.size(); outerIdx++) {
			for (int innerIdx = 0; innerIdx < words.size(); innerIdx++) {
				if (outerIdx != innerIdx) {
					cWordSet.add(words.get(outerIdx) + words.get(innerIdx));
				}
			}
		}
		writeOut(cWordSet);
	}

	private List<String> readWords() {
		List<String> words = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String line = "";
			while ((line = br.readLine()) != null) {
				for (String st : line.split(" ")) {
					words.add(st);
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return words;
	}

	private void writeOut(Set<String> words) {
		try (PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
			for (String word : words) {
				pr.println(word);
			}
			pr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
