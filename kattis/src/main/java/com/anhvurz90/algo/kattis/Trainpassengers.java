package com.anhvurz90.algo.kattis;

import java.util.Scanner;

public class Trainpassengers {
	
	public static void main(String[] args) {
		new Trainpassengers().run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		long c = sc.nextLong();
		int n = sc.nextInt();
		
		long passengers = 0;
		boolean ok = true;
		for (int station = 0; station < n; station++) {
			int left = sc.nextInt();
			int enter = sc.nextInt();
			int wait = sc.nextInt();
			
			passengers-= left;
			if (passengers < 0) {
				ok = false;
				break;
			}
			
			passengers+= enter;
			if (passengers > c) {
				ok = false;
				break;				
			}
			
			if (passengers < c && wait > 0) {
				ok = false;
				break;
			}
		}
		
		if (passengers != 0) {
			ok = false;
		}
		
		System.out.println(ok ? "possible" : "impossible");
		sc.close();
	}

}

