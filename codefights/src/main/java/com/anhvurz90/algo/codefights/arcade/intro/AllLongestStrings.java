package com.anhvurz90.algo.codefights.arcade.intro;

public class AllLongestStrings {
	String[] allLongestStrings(String[] inputArray) {
		int maxLen = findMaxLen(inputArray);

		int count = 0;
		for (String s : inputArray) {
			if (s.length() == maxLen) {
				count++;
			}
		}

		String[] ret = new String[count];
		count = 0;
		for (String s : inputArray) {
			if (s.length() == maxLen) {
				ret[count++] = s;
			}
		}

		return ret;
	}

	int findMaxLen(String[] arr) {
		int max = 0;
		for (String st : arr) {
			max = Math.max(max, st.length());
		}

		return max;
	}

}
