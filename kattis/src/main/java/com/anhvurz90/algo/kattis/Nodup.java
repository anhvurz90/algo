package com.anhvurz90.algo.kattis;

import java.util.Scanner;

public class Nodup {

	public static void main(String[] args) {
		new Nodup().run();
	}

	private void run() {
		String[] words = new Scanner(System.in).nextLine().split(" ");
		String ret = "yes";
		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if (words[i].equals(words[j])) {
					ret = "no";
				}
			}
		}
		System.out.println(ret);
	}
}
