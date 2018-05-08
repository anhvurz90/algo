package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Pizzahawaii {

	public static void main(String[] args) {
		new Pizzahawaii().run();
	}

	private void run() {
		List<Test> tests = readTests();
		for (int testIdx = 0; testIdx < tests.size(); testIdx++) {
			printPairs(tests.get(testIdx));
			if (testIdx < tests.size() - 1) {
				System.out.println();
			}
		}
	}

	private List<Test> readTests() {
		List<Test> tests = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			int testCount = Integer.parseInt(br.readLine());
			for (int testIdx = 0; testIdx < testCount; testIdx++) {
				Test test = new Test();

				int pizzaCount = Integer.parseInt(br.readLine());
				for (int pizzaIdx = 0; pizzaIdx < pizzaCount; pizzaIdx++) {
					Pizza pizza = new Pizza();
					pizza.name = br.readLine();
					pizza.italianNames = Arrays.stream(br.readLine().split(" ")).skip(1).collect(Collectors.toList());
					pizza.nativeNames = Arrays.stream(br.readLine().split(" ")).skip(1).collect(Collectors.toList());

					test.pizzas.add(pizza);
				}

				tests.add(test);
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return tests;
	}

	private void printPairs(Test test) {
		Map<String, Set<String>> italianIngres = new TreeMap<>();
		Map<String, Set<String>> nativeIngres = new TreeMap<>();
		for (Pizza pizza : test.pizzas) {
			Set<String> nativeNames = new HashSet<>(pizza.nativeNames);
			Set<String> italianNames = new HashSet<>(pizza.italianNames);
			for (String italianName : pizza.italianNames) {
				if (!italianIngres.containsKey(italianName)) {
					italianIngres.put(italianName, new TreeSet<>(nativeNames));
				} else {
					Set<String> oldNames = italianIngres.get(italianName);
					oldNames.retainAll(nativeNames);
				}
			}

			for (String nativeName : pizza.nativeNames) {
				if (!nativeIngres.containsKey(nativeName)) {
					nativeIngres.put(nativeName, new TreeSet<>(italianNames));
				} else {
					Set<String> oldNames = nativeIngres.get(nativeName);
					oldNames.retainAll(italianNames);
				}
			}
		}

		for (String italianName : italianIngres.keySet()) {
			for (String nativeName : italianIngres.get(italianName)) {
				if (nativeIngres.containsKey(nativeName) && nativeIngres.get(nativeName).contains(italianName)) {
					System.out.format("(%s, %s)\n", italianName, nativeName);
				}
			}
		}
	}

	class Test {
		List<Pizza> pizzas = new ArrayList<>();
	}

	class Pizza {
		String name;
		List<String> italianNames = new ArrayList<>();
		List<String> nativeNames = new ArrayList<>();
	}
}
