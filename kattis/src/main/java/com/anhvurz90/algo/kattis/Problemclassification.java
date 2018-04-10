package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problemclassification {

	public static void main(String[] args) {
		new Problemclassification().run();
	}

	private void run() {
		List<String> inputs = readInputs();
		List<Category> categories = readCategories(inputs);
		List<String> statement = readStatement(inputs, categories.size());
		for (String word: statement) {
			for (Category c : categories) {
				if (c.words.contains(word)) {
					c.apperanceCount ++;
				}
			}
		}
		
//		System.out.println(categories);
		int max = categories.stream()
							.map(c -> c.apperanceCount)
							.max(Integer::compare)
							.get();
		
//		System.out.println(statement);
//		System.out.println(max);
		categories.stream()
				  .filter(c -> c.apperanceCount == max)
				  .map(c -> c.name)
				  .sorted()
				  .forEach(System.out::println);
	}
	
	private List<String> readInputs() {
		List<String> inputs = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in))) {
//				new InputStreamReader(new FileInputStream("problemclassification.in")))) {
			String line;
			while ((line = br.readLine()) != null) {
				inputs.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputs;
	}

	private List<Category> readCategories(List<String> inputs) {
		List<Category> categories = new ArrayList<>();
		int categoryCount = Integer.parseInt(inputs.get(0));
		for (int i = 0; i < categoryCount; i++) {
			String[] tokens = inputs.get(i+1).split(" ");
			Category c = new Category();
			c.name = tokens[0];
			c.apperanceCount = 0;
			c.words = new HashSet<>();
			for (int tokenIdx = 2; tokenIdx < tokens.length; tokenIdx++) {
				c.words.add(tokens[tokenIdx]);
			}
			categories.add(c);
		}
		return categories;
	}
	
	private List<String> readStatement(List<String> inputs, int categoryCount) {
		List<String> statement = new ArrayList<>();
		for (int i = categoryCount + 1; i < inputs.size(); i++) {
			statement.addAll(Arrays.asList(inputs.get(i).split(" ")));
		}
		return statement;
	}

	class Category {
		String name;
		Set<String> words;
		int apperanceCount;
		@Override
		public String toString() {
			return "Category [name=" + name + ", words=" + words + ", apperanceCount=" + apperanceCount + "]";
		}
		
	}
}
