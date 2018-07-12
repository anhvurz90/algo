package com.anhvurz90.algo.kattis;

import java.util.Scanner;

public class Smartphone {

	public static void main(String[] args) {
		new Smartphone().run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int testCount = Integer.parseInt(sc.nextLine());
		for (int testI = 0; testI < testCount; testI++) {
			String word = sc.nextLine();
			String current = sc.nextLine();
			String s1 = sc.nextLine();
			String s2 = sc.nextLine();
			String s3 = sc.nextLine();

			int min = fill(word, current);
			min = Math.min(min, fill(word, s1) + 1);
			min = Math.min(min, fill(word, s2) + 1);
			min = Math.min(min, fill(word, s3) + 1);

			System.out.println(min);
		}
		sc.close();
	}

	private int fill(String word, String s) {
		int c = leftCommon(word, s);

		return Math.abs(word.length() - c) + Math.abs(s.length() - c);
	}

	private int leftCommon(String s1, String s2) {
		int idx = 0;
		while (idx < s1.length() && idx < s2.length() && s1.charAt(idx) == s2.charAt(idx)) {
			idx++;
		}
		return idx;
	}

}
