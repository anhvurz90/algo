package com.anhvurz90.algo.codefights.arcade.intro;

public class MatrixElementsSum {

	int matrixElementsSum(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		int[] minZeroRow = new int[col];
		java.util.Arrays.fill(minZeroRow, row);
		for (int r = row - 1; r >= 0; r--) {
			for (int c = 0; c < col; c++) {
				if (matrix[r][c] == 0) {
					minZeroRow[c] = r;
				}
			}
		}

		// for (int c = 0; c < col; c++) {
		// System.out.println(c + ": " + minZeroRow[c]);
		// }

		int sum = 0;
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (minZeroRow[c] > r) {
					sum += matrix[r][c];
				}
			}
		}

		return sum;
	}
}
