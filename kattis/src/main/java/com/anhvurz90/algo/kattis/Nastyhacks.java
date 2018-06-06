package com.anhvurz90.algo.kattis;

import java.util.Scanner;

public class Nastyhacks {

	public static void main(String[] args) {
		new Nastyhacks().run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int r = sc.nextInt();
			int e = sc.nextInt();
			int c = sc.nextInt();
			System.out.println(e - c > r ? "advertise" :
							   (e - c == r ? "does not matter" : "do not advertise"));
		}
		
		sc.close();
	}
}
