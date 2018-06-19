package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Eligibility {

	public static void main(String[] args) {
		new Eligibility().run();
	}

	private void run() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {

			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				String[] info = br.readLine().split(" ");
				String name = info[0];

				int firstBegan = Integer.parseInt(info[1].split("/")[0]);
				int born = Integer.parseInt(info[2].split("/")[0]);

				int courses = Integer.parseInt(info[3]);

				pr.print(name);
				if (firstBegan >= 2010 || born >= 1991) {
					pr.println(" eligible");
				} else if (courses > 40) {
					pr.println(" ineligible");
				} else {
					pr.println(" coach petitions");
				}
			}
			br.close();
			pr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
