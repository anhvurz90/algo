package com.anhvurz90.algo.codefights.challenge;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Kbonacci {

	String kbonacci(int k, int n) {
		if (n < k) {
			return "1";
		}
		if (n == k) {
			return k + "";
		}
		List<BigInteger> list = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			list.add(BigInteger.ONE);
		}
		list.add(BigInteger.valueOf(k));

		BigInteger two = BigInteger.valueOf(2);
		for (int i = 0; i < n - k; i++) {
			int lastIdx = list.size() - 1;
			BigInteger val = list.get(lastIdx).multiply(two).subtract(list.get(lastIdx - k));
			list.set((lastIdx - k), null);
			list.add(val);
		}
		return list.get(list.size() - 1).toString();
	}

	public static void main(String[] args) {
		System.out.println(new Kbonacci().kbonacci(3, 4));
	}
}
