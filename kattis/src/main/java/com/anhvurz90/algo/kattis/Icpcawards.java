package com.anhvurz90.algo.kattis;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Icpcawards {

	public static void main(String[] args) {
		new Icpcawards().run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());

		Map<String, String> teams = new LinkedHashMap<>();

		for (int i = 0; i < n; i++) {
			String[] names = sc.nextLine().split(" ");
			String university = names[0];
			String team = names[1];
			if (!teams.containsKey(university)) {
				teams.put(university, team);
			}
			if (teams.size() == 12) {
				break;
			}
		}

		for (String uni : teams.keySet()) {
			System.out.println(uni + " " + teams.get(uni));
		}
		sc.close();
	}
}
