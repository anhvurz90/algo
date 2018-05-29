package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Jewelrybox {

	public static void main(String[] args) {
		new Jewelrybox().run();
	}

	private void run() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {

			int testCount = Integer.parseInt(br.readLine());
			for (int testIdx = 0; testIdx < testCount; testIdx++) {
				String[] pair = br.readLine().split(" ");
				int x = Integer.parseInt(pair[0]);
				int y = Integer.parseInt(pair[1]);

				double delta = Math.sqrt(x * x + y * y - x * y);
				double h1 = (x + y + delta) / 6;
				double h2 = (x + y - delta) / 6;

				pr.println(Math.max(f(h1, x, y), f(h2, x, y)));
			}
			br.close();
			pr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private double f(double h, double x, double y) {
		return h * (x - 2 * h) * (y - 2 * h);
	}
}
