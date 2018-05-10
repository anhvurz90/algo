package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beekeeper {

	public static void main(String[] args) {
		new Beekeeper().run();
	}

	private void run() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			boolean stop = false;
			while (!stop) {
				int wordCount = Integer.parseInt(br.readLine());
				stop = wordCount == 0;
				if (!stop) {
					int bestVal = -1;
					String ret = "";
					for (int wordIdx = 0; wordIdx < wordCount; wordIdx++) {
						String word = br.readLine();
						int pairCount = countPair(word);
						if (pairCount > bestVal) {
							bestVal = pairCount;
							ret = word;
						}
					}
					System.out.println(ret);
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int countPair(String word) {
		int pairCount = 0;
		for (int i = 1; i < word.length(); i++) {
			if (("aeiouy".indexOf(word.charAt(i)) > -1) && (word.charAt(i - 1) == word.charAt(i))) {
				pairCount++;
			}
		}
		return pairCount;
	}
}
