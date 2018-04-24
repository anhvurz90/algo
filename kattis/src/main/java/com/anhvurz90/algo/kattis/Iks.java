package com.anhvurz90.algo.kattis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Iks {

	public static void main(String[] args) {
		new Iks().run();
	}

	private void run() {
		List<Integer> numbers = readInputNumbers();
		
		Map<Integer, Map<Integer, Integer>> numPrimeCounts = new HashMap<>();
		Map<Integer, Integer> primeCounts = new HashMap<>();
		Set<Integer> primes = getPrimes();
		
		for (int num : numbers) {
			Map<Integer, Integer> subPrimeCounts = countPrimes(num, primes);
			for (int prime : subPrimeCounts.keySet()) {
				int oldCount = primeCounts.containsKey(prime) ? 
									primeCounts.get(prime) : 0;
				primeCounts.put(prime, oldCount + subPrimeCounts.get(prime));
			}
			
			numPrimeCounts.put(num, subPrimeCounts);
		}
		
		int score = 1;
		int time = 0;
		for (Map.Entry<Integer, Integer> primeCount : primeCounts.entrySet()) {
			int prime = primeCount.getKey();
			int count = primeCount.getValue();
			int countEach = count / numbers.size();
			score*= (int)Math.pow(prime, countEach);
			
			for (int num: numbers) {
				Map<Integer, Integer> subPrimeCount = numPrimeCounts.get(num);
//				System.out.println(prime + " " + num + " " + subPrimeCount);
				int subCount = subPrimeCount.containsKey(prime) ? 
									subPrimeCount.get(prime) : 0;
				if (subCount < countEach) {
					time += countEach - subCount;
				}
			}
		}
		
		System.out.format("%d %d\n", score, time);
	}

	private List<Integer> readInputNumbers() {
		Scanner sc = new Scanner(System.in);
		int numCount = Integer.parseInt(sc.nextLine());
		List<Integer> numbers = 
				Arrays.stream(sc.nextLine().split(" "))
					 .map(st -> Integer.parseInt(st))
					 .collect(Collectors.toList());
		sc.close();
		return numbers;
	}
	
	private static final int MAX = (int)Math.pow(10, 6) + 2;
	
	private Set<Integer> getPrimes() {
		Set<Integer> primes = new HashSet<>();
		for (int num = 2; num < Math.sqrt(MAX); num++) {
			boolean isPrime = true;
			for (int prime: primes) {
				if (num % prime == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primes.add(num);
			}
		}
		
		return primes;
	}

	private Map<Integer, Integer> countPrimes(int num, Set<Integer> primes) {
//		System.out.println(num);
		Map<Integer, Integer> primeCounts = new HashMap<>();
		for (int prime: primes) {
			int count = primeCounts.containsKey(prime) ? 
							primeCounts.get(prime) : 0;
			while (num % prime == 0) {
				num /= prime;
				count ++;
			}
			if (count > 0) {
				primeCounts.put(prime, count);
			}
		}
//		System.out.println(primeCounts);
		if (num > 1) {
			int count = primeCounts.containsKey(num) ? 
					primeCounts.get(num) : 0;
			primeCounts.put(num, count + 1);
		}
		return primeCounts;
	}

}
