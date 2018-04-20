package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Batteries {

	public static void main(String[] args) {
		new Batteries().run();
	}

	private void run() {
		List<Integer> levels = readInputs();
		List<Integer> minTestCounts = new ArrayList<>();
		Map<Integer, Integer> cachedResults = new HashMap<>();
		levels.forEach(
			level -> {
				if (!cachedResults.containsKey(level)) {
					cachedResults.put(level, findMinTestCount(level));
				}
				minTestCounts.add(cachedResults.get(level));
			}
		);
		writeOutputs(minTestCounts);
	}
	
	private void writeOutputs(List<Integer> minTestCounts) {
		PrintWriter pr = new PrintWriter(
			new BufferedWriter(
					new OutputStreamWriter(System.out)));
		minTestCounts.forEach(
			count -> pr.println(count)
		);
		pr.close();
	}

	private List<Integer> readInputs() {
		List<Integer> levels = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in))) {
			while (true) {
				int level = Integer.parseInt(br.readLine());
				if (level != 0) {
					levels.add(level);
				} else {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return levels;
	}
	
	private int findMinTestCount(int level) {
		int m = level - 1;
		double maxX = Math.sqrt(2 * m) - 1;
		double val = f(maxX, m);
		
		double floor = Math.floor(val);
		return equal(val, floor) ? (int)val : (int)(val+1);
	}
	
	private static final double ESP = Math.pow(10, -5);
	private boolean equal(double a, double b) {
		return Math.abs(a - b) < ESP;
	}

	private double f(double x, int m) {
		return m / (x + 1) + x / 2;
	}
}
