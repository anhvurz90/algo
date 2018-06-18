package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class NumberFun {

	public static void main(String[] args) {
		new NumberFun().run();
	}

	private void run() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {

			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				String[] triple = br.readLine().split(" ");
				int a = Integer.parseInt(triple[0]);
				int b = Integer.parseInt(triple[1]);
				int c = Integer.parseInt(triple[2]);

				System.out.println(a + b == c || a * b == c ||
								   a - b == c || b - a == c || 
								   a == b * c || b == a * c ? 
								   "Possible" : "Impossible");
			}
			br.close();
			pr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
