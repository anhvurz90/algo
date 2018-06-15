
//package com.anhvurz90.algo.kattis;

import java.util.Scanner;

public class Cudoviste {

	public static void main(String[] args) {
		new Cudoviste().run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);

		String[] pair = sc.nextLine().split(" ");
		int rowCount = Integer.parseInt(pair[0]);
		int colCount = Integer.parseInt(pair[1]);

		char[][] parkingPlace = new char[rowCount][colCount];
		for (int i = 0; i < rowCount; i++) {
			parkingPlace[i] = sc.nextLine().toCharArray();
		}

		int[] count = new int[5];
		for (int a = 0; a < rowCount - 1; a++) {
			for (int b = 0; b < colCount - 1; b++) {
				if (canPark(parkingPlace[a][b]) && canPark(parkingPlace[a + 1][b]) && canPark(parkingPlace[a][b + 1])
						&& canPark(parkingPlace[a + 1][b + 1])) {
					int cars = isCar(parkingPlace[a][b]) + isCar(parkingPlace[a + 1][b]) + isCar(parkingPlace[a][b + 1])
							+ isCar(parkingPlace[a + 1][b + 1]);
					count[cars]++;
				}
			}
		}

		for (int c : count) {
			System.out.println(c);
		}
		sc.close();
	}

	private boolean canPark(char c) {
		return c != '#';
	}

	private int isCar(char c) {
		return c == 'X' ? 1 : 0;
	}
}
