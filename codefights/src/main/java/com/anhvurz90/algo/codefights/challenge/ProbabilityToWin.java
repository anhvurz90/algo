package com.anhvurz90.algo.codefights.challenge;

public class ProbabilityToWin {

	public static void main(String[] args) {
		new ProbabilityToWin().run();
	}

	private void run() {
		int[][] prob = new int[][] { { 0, 20, 30, 20, 25, 25, 10, 30 }, { 80, 0, 50, 60, 60, 40, 30, 50 },
				{ 70, 50, 0, 40, 40, 50, 60, 60 }, { 80, 40, 60, 0, 70, 50, 60, 40 }, { 75, 40, 60, 30, 0, 50, 50, 50 },
				{ 75, 60, 50, 50, 50, 0, 60, 70 }, { 90, 70, 40, 40, 50, 40, 0, 80 },
				{ 70, 50, 40, 60, 50, 30, 20, 0 } };
		double[] ret = probabilityToWin(prob);
		for (double d : ret) {
			System.out.println(d);
		}
	}

	double[] probabilityToWin(int[][] prob) {
		int teams = prob.length;
		int totalTeams = prob.length;
		int round = 0;
		double[][] ptw = new double[totalTeams][totalTeams];
		while (teams > 1) {
			if (round == 0) {
				for (int i = 0; i < totalTeams; i++) {
					ptw[round][i] = prob[i][i % 2 == 0 ? i + 1 : i - 1];
				}
			} else {
				for (int a = 0; a < totalTeams; a++) {
					int[] opponents = getOpponents(a, round, totalTeams);
					for (int b : opponents) {
						ptw[round][a] += ptw[round - 1][b] * prob[a][b] / 100.0;
					}
					ptw[round][a] *= ptw[round - 1][a] / 100.0;
				}
			}
			round++;
			teams /= 2;
		}
		return ptw[round - 1];
	}

	private int[] getOpponents(int a, int round, int total) {
		int len = (int) Math.pow(2, round);
		int[] opponents = new int[len];

		int from = 0;
		int to = total;
		while (to - from > len * 2) {
			int mid = (from + to) / 2;
			if (a < mid) {
				to = mid;
			} else {
				from = mid;
			}
		}

		int mid = (from + to) / 2;
		if (a < mid) {
			from = mid;
		} else {
			to = mid;
		}

		int count = 0;
		for (int i = from; i < to; i++) {
			opponents[count++] = i;
		}
		return opponents;
	}

}
