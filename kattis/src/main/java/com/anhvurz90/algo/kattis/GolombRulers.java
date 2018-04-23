package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GolombRulers {

	public static void main(String[] args) {
		new GolombRulers().run();
	}

	private void run() {
		List<List<Integer>> golombs = readGolombs();
		List<String> answers = new ArrayList<>();
		golombs.forEach(
			golomb -> {
				Collections.sort(golomb);
				String answer = checkGolomb(golomb);
				answers.add(answer);
			}
		);
		writeAnswers(answers);
	}

	private List<List<Integer>> readGolombs() {
		List<List<Integer>> golombs = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in))) {
			String line = null;
			int count = 0;
			while ((line = br.readLine()) != null) {
				golombs.add(
					Arrays.stream(line.split(" "))
						  .map(s -> Integer.parseInt(s))
						  .collect(Collectors.toList()));
				
//				if (++count == 5) break;
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return golombs;
	}

	private String checkGolomb(List<Integer> golomb) {
		int maxVal = golomb.get(golomb.size() - 1);
		int size = golomb.size();
		int[] flag = new int[maxVal+1];
		
		for (int outerIdx = 0; outerIdx < size; outerIdx++) {
			for (int innerIdx = outerIdx + 1; innerIdx < size; innerIdx++) {
				int diff = golomb.get(innerIdx) - golomb.get(outerIdx);
				if (flag[diff]++ != 0) {
					return "not a ruler";
				}
			}
		}
		
		if (maxVal == size * (size - 1) / 2) {
			return "perfect";
		}
		
		StringBuilder answer = new StringBuilder("missing");
		for (int i = 1; i < maxVal + 1; i++) {
			if (flag[i] == 0) {
				answer.append(" ").append(i);
			}
		}
		return answer.toString();
	}

	private void writeAnswers(List<String> answers) {
		try(PrintWriter pr = new PrintWriter(
				new BufferedWriter(
					new OutputStreamWriter(System.out)))) {
			answers.forEach(System.out::println);
			pr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
