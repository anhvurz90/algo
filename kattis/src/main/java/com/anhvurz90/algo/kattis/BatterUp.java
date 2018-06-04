package com.anhvurz90.algo.kattis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BatterUp {

	public static void main(String[] args) {
		new BatterUp().run();
	}

	public void run() {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		List<Integer> bats = new ArrayList<>(n);

		for (int i = 0; i < n; i++) {
			bats.add(sc.nextInt());
		}

		int count = (int) bats.stream().filter(item -> item != -1).count();

		int sum = bats.stream().filter(item -> item != -1).mapToInt(i -> i).sum();

		System.out.println(1.0 * sum / count);
		sc.close();
	}
}
