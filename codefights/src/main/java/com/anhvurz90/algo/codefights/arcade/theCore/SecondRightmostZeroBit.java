package com.anhvurz90.algo.codefights.arcade.theCore;

public class SecondRightmostZeroBit {
	int secondRightmostZeroBit(int n) {
		return 1 << (Integer.toBinaryString(n).length() - 1
				- Integer.toBinaryString(n).lastIndexOf('0', Integer.toBinaryString(n).lastIndexOf('0') - 1));
	}
}
