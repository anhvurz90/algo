package com.anhvurz90.algo.kattis;

import java.util.Scanner;

public class Quadrant {

	public static void main(String[] args) {
		new Quadrant().run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();

		if (x > 0) {
			System.out.println(y > 0 ? 1 : 4);
		} else {
			System.out.println(y > 0 ? 2 : 3);
		}

		sc.close();
	}

}
