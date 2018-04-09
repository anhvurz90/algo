package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Happyprime {

	public static void main(String[] args) {
		new Happyprime().run();
	}

	private void run() {
		List<Pair> inputs = readInput();
		int max = inputs.stream()
						.map(p -> p.right)
						.max(Integer::compare)
						.get();
		Set<Integer> primes = findAllPrimes(max);
		Set<Integer> happies = findAllHappies(inputs, primes);
		
		writeOutput(inputs, happies);
	}
	
	private void writeOutput(List<Pair> inputs, Set<Integer> happies) {
		inputs.stream()
			  .forEach(p -> {
				  System.out.format("%d %d %s\n",
						  p.left, p.right,
						  happies.contains(p.right) ? "YES" : "NO");
			  });
	}

	private static final byte UNKNOWN = 0;
	private static final byte HAPPY = 1;
	private static final byte UNHAPPY = 2;
	private static final int MAX = 10000;
	
	private Set<Integer> findAllHappies(List<Pair> inputs, Set<Integer> primes) {
		byte[] flag = new byte[MAX + 1];
		Arrays.fill(flag, UNKNOWN);
		flag[1] = HAPPY;
		
		Set<Integer> ret = new HashSet<>();
		for (Pair pair : inputs) {
			if (primes.contains(pair.right)) {
				int prime = pair.right;
				int p = prime;
	//			System.out.println(p);
				List<Integer> num = new ArrayList<>();
				num.add(p);
				Set<Integer> visited = new HashSet<>();
				
				while (true) {
	//				System.out.print(p + " ");
					if (flag[p] == HAPPY) {
						update(flag, num, HAPPY);
						ret.add(prime);
	//					System.out.println("Break: " + p);
						break;
					}
					if (flag[p] == UNHAPPY) {
						update(flag, num, UNHAPPY);
						break;
					}
					//UNKNOWN case
					if (visited.contains(p)) {
						update(flag, num, UNHAPPY);
						break;
					}
					visited.add(p);
					
					p = next(p);
					num.add(p);
				}
			}
//			System.out.println();
		}
		
//		System.out.println("RET: " + ret);
		return ret;
	}

	private int next(int p) {
		int ret = 0;
		while (p > 0) {
			int lDigit = p % 10;
			ret += lDigit * lDigit;
			p/= 10;
		}
		return ret;
	}

	private void update(byte[] flag, List<Integer> num, byte state) {
		for (int n : num) {
			flag[n] = state;
		}
	}

	private Set<Integer> findAllPrimes(int max) {
		boolean[] isPrime = new boolean[max + 1];
		Arrays.fill(isPrime, true);
		int idx = 2;
		
		Set<Integer> ret = new HashSet<>();
		while (idx <= max) {
			if (isPrime[idx]) {
				ret.add(idx);
				int mul = 2;
				while (mul * idx <= max) {
					isPrime[mul * idx] = false;
					mul ++;
				}
			}
			idx++;
		}
		return ret;
	}

	private List<Pair> readInput() {
		List<Pair> ret = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				String line = br.readLine();
				List<Integer> ints = 
					Arrays.stream(line.split(" "))
						  .map(s -> Integer.parseInt(s))
						  .collect(Collectors.toList());
				ret.add(new Pair(ints.get(0), ints.get(1)));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	class Pair {
		int left;
		int right;
		
		public Pair(int l, int r) {
			this.left = l;
			this.right = r;
		}
	}
}
