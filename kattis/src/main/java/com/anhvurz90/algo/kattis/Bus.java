package com.anhvurz90.algo.kattis;

import java.util.Scanner;

public class Bus {

	public static void main(String[] args) {
		new Bus().run();
	}

	private void run() {

		int n = 30;
		long[] vals = new long[n + 1];
		vals[1] = 1;
		for (int i = 2; i <= n; i++) {
			vals[i] = 2 * vals[i - 1] + 1;
		}

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int k = sc.nextInt();
			System.out.println(vals[k]);
		}

		sc.close();

	}
}
