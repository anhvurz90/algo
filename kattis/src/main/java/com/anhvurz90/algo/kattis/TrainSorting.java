package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TrainSorting {

	public static void main(String[] args) {
		new TrainSorting().run();
	}

	private void run() {
		int[] cars = readInputCars();
		if (cars == null) {
			System.out.println(0);
			return;
		}
		BestVal[] bestVal = calculateBestVal(cars);
		
		System.out.println(
				Arrays.stream(bestVal)
				      .map(v -> v.longestUp + v.longestDown + 1)
				      .max(Integer::compare)
				      .get());

	}
	
	private BestVal[] calculateBestVal(int[] cars) {
		int n = cars.length;
		BestVal[] bestVal = new BestVal[n];
		
		bestVal[n-1] = new BestVal(0, 0);
		
		for (int outerIdx = n-1; outerIdx >= 0; outerIdx--) {
			bestVal[outerIdx] = new BestVal(0, 0);
			for (int innerIdx = outerIdx+1; innerIdx < n; innerIdx++) {
				if (cars[outerIdx] > cars[innerIdx]) {
					bestVal[outerIdx].longestUp = Math.max(bestVal[outerIdx].longestUp, bestVal[innerIdx].longestUp + 1);
				} else if (cars[outerIdx] < cars[innerIdx]) {
					bestVal[outerIdx].longestDown = Math.max(bestVal[outerIdx].longestDown, bestVal[innerIdx].longestDown + 1);
				}
			}
		}
		
//		System.out.println(Arrays.asList(bestVal));
		return bestVal;
	}

	private int[] readInputCars() {
		int[] cars = null;
		try(BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				return cars;
			}
			cars = new int[n];
			for (int idx = 0; idx < n; idx++) {
				cars[idx] = Integer.parseInt(br.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cars;
	}
	
	class BestVal {
		int longestUp;
		int longestDown;
		
		public BestVal() {
		}

		public BestVal(int longestUp, int longestDown) {
			super();
			this.longestUp = longestUp;
			this.longestDown = longestDown;
		}

		@Override
		public String toString() {
			return "BestVal [longestUp=" + longestUp + ", longestDown=" + longestDown + "]";
		}
		
	}
}
