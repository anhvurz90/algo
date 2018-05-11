package com.anhvurz90.algo.codefights.arcade.intro;

public class CommonCharacterCount {

	int commonCharacterCount(String s1, String s2) {
		char a = 'a';
		char z = 'z';
		int[] count1 = new int[z - a + 1];
		int[] count2 = new int[z - a + 1];

		for (int idx = 0; idx < s1.length(); idx++) {
			count1[s1.charAt(idx) - 'a']++;
		}
		for (int idx = 0; idx < s2.length(); idx++) {
			count2[s2.charAt(idx) - 'a']++;
		}

		int sum = 0;
		for (int idx = 0; idx <= z - a; idx++) {
			sum += Math.min(count1[idx], count2[idx]);
		}

		return sum;

	}

}
