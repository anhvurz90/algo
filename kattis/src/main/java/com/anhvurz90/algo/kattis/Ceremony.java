package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ceremony {

	public static void main(String[] args) {
		new Ceremony().run();
	}

	private void run() {
		int[] towers = readTowers();
		int n = towers.length;
		Arrays.parallelSort(towers);
		
		int minCharge = n;
		for (int idx = 0; idx < n; idx++) {
			minCharge = Math.min(minCharge, towers[idx] + n - 1 - idx);
		}
		
		System.out.println(minCharge);
	}

	private int[] readTowers() {
		int[] towers = null;
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			towers = new int[n];
			String[] stVal = br.readLine().split(" ");
			for (int idx = 0; idx < stVal.length; idx++) {
				towers[idx] = Integer.parseInt(stVal[idx]);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return towers;
	}
}
