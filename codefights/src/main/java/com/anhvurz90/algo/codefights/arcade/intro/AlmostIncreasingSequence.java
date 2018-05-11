package com.anhvurz90.algo.codefights.arcade.intro;

public class AlmostIncreasingSequence {

	boolean almostIncreasingSequence(int[] sequence) {
		int idx = -1;
		int wrongOrderCount = 0;
		for (int i = 1; i < sequence.length; i++) {
			if (sequence[i] <= sequence[i - 1]) {
				idx = i;
				wrongOrderCount++;
			}
		}
		// System.out.println(wrongOrderCount);
		if (wrongOrderCount == 0) {
			return true;
		} else if (wrongOrderCount > 1) {
			return false;
		} else {
			int[] seq1 = remove(sequence, idx - 1);
			int[] seq2 = remove(sequence, idx);

			return okIncreasing(seq1) || okIncreasing(seq2);
		}
	}

	private boolean okIncreasing(int[] seq) {
		for (int i = 1; i < seq.length; i++) {
			if (seq[i] <= seq[i - 1]) {
				return false;
			}
		}
		return true;
	}

	private int[] remove(int[] seq, int idx) {
		int len = seq.length;
		int[] ret = new int[len - 1];

		System.arraycopy(seq, 0, ret, 0, idx);
		System.arraycopy(seq, idx + 1, ret, idx, len - idx - 1);

		// for (int i : ret)
		// System.out.print(i + " ");
		// System.out.println();
		return ret;
	}

	public static void main(String[] args) {
		AlmostIncreasingSequence a = new AlmostIncreasingSequence();

		int[] seq = new int[] { 1, 1, 1, 2, 3 };

		a.almostIncreasingSequence(seq);
		// System.out.println(a.almostIncreasingSequence(seq));
	}

}
