package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Loowater {

	public static void main(String[] args) {
		new Loowater().run();
	}

	private static final String DOOM = "Loowater is doomed!";
	
	private void run() {
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in))) {
			boolean stop = false;
			while (!stop) {
				String[] headKnights = br.readLine().split(" ");
				int headCount = Integer.parseInt(headKnights[0]);
				int knightCount = Integer.parseInt(headKnights[1]);
				
				stop = (headCount == 0) && (knightCount == 0);
				if (!stop) {
					if (headCount > knightCount) {
						System.out.println(DOOM);
						break;
					}
					int[] heads = new int[headCount];
					for (int headIdx = 0; headIdx < headCount; headIdx++) {
						heads[headIdx] = Integer.parseInt(br.readLine());
					}
					
					int[] knights = new int[knightCount];
					for (int knightIdx = 0; knightIdx < knightCount; knightIdx++) {
						knights[knightIdx] = Integer.parseInt(br.readLine());
					}
					
					Arrays.sort(heads);
					Arrays.sort(knights);
					
					boolean doom = false;
					int knightIdx = 0;
					int cost = 0;
					for (int headIdx = 0; headIdx < headCount; headIdx++) {
						while((knightIdx < knightCount) && knights[knightIdx] < heads[headIdx]) {
							knightIdx++;
						}
//						System.out.println("idx: " + knightIdx);
						if (knightIdx == knightCount) {
							doom = true;
							break;
						} else {
							cost+= knights[knightIdx++]; 
						}
					}
					System.out.println(doom ? DOOM : cost);
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
