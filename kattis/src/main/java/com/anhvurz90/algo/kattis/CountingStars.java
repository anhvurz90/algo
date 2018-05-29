package com.anhvurz90.algo.kattis;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CountingStars {

	private static final List<Integer> deltaX = Arrays.asList(-1, 1, 0, 0);
	private static final List<Integer> deltaY = Arrays.asList(0, 0, -1, 1);

	public static void main(String[] args) throws IOException {
		new CountingStars().run();
	}

	StringBuilder[] sky;

	private void run() throws IOException {
		Scanner sc = new Scanner(System.in);
		// new Scanner(new File("CountingStars.inp"));

		int count = 0;
		while (sc.hasNext()) {
			String[] pair = sc.nextLine().split(" ");
			int m = Integer.parseInt(pair[0]);
			int n = Integer.parseInt(pair[1]);
			sky = new StringBuilder[m];
			// System.out.println(m + " " + n);
			for (int i = 0; i < m; i++) {
				sky[i] = new StringBuilder(sc.nextLine());
				// System.out.println(sky[i]);
			}

			System.out.format("Case %d: %d\n", ++count, countStars());
		}
		sc.close();
	}

	private int countStars() {
		int ret = 0;
		for (int i = 0; i < sky.length; i++)
			for (int j = 0; j < sky[0].length(); j++) {
				if (sky[i].charAt(j) == '-') {
					ret++;
					// System.out.println(ret);
					spread(i, j);
				}
			}
		return ret;
	}

	private void spread(int x, int y) {
		// System.out.println(x + " - " + y);
		sky[x].setCharAt(y, '*');

		for (int i = 0; i < deltaX.size(); i++) {
			int newx = x + deltaX.get(i);
			int newy = y + deltaY.get(i);
			if (newx > -1 && newx < sky.length && newy > -1 && newy < sky[0].length()
					&& sky[newx].charAt(newy) == '-') {
				spread(newx, newy);
			}
		}
	}
}
