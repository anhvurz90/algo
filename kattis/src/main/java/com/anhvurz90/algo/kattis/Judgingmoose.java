package com.anhvurz90.algo.kattis;

import java.util.Scanner;

public class Judgingmoose {

	public static void main(String[] args) {
		new Judgingmoose().run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		
		int left = sc.nextInt();
		int right = sc.nextInt();
		
		int sum = left + right;
		String ret = sum == 0 ? "Not a moose" : 
					 (left == right) ? "Even " + sum : "Odd " + (2 * Math.max(left, right)); 
		
		System.out.println(ret);
		
		sc.close();
	}
}
