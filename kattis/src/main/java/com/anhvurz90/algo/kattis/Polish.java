package com.anhvurz90.algo.kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Polish {

	public static void main(String[] args) {
		new Polish().run();
	}

	private void run() {
		List<String> expressions = readExpressions();
		int exIdx = 0;
		for (String expression: expressions) {
			System.out.println("Case " + (++exIdx) + ":" + reduce(expression));
		}
	}
	
	private List<String> readExpressions() {
		List<String> expressions = new ArrayList<>();
		int count = 0;
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in))) {
			String line;
			while ((line = br.readLine()) != null) {
				expressions.add(line);
//				if (++count == 4) break;
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return expressions;
	}
	
	private String reduce(String expression) {
		Stack<Object> stack = new Stack<>();
		for (String token : expression.split(" ")) {
			if (isNumber(token) && stack.size() > 1) {
				Integer num = Integer.parseInt(token);
				reduceTopStack(stack, num);
			} else {
				stack.push(isNumber(token) ? Integer.parseInt(token) : token);
			}
//			System.out.println(stack);
		}

		return ((String) stack.stream()
					.reduce("", (a, b) -> a + " " + b));
	}
	
	private void reduceTopStack(Stack<Object> stack, Integer num) {
		Object o1 = stack.pop();
		Object o2 = stack.pop();
//		System.out.println(num + " " + o1 + " " + o2);
//		System.out.println((o1 instanceof Integer));
//		System.out.println(isOperator(o2));
		if ((o1 instanceof Integer) && isOperator(o2)) {
			Integer val = evaluate(o1, num, o2);
			if (stack.size() > 1) {
				reduceTopStack(stack, val);
			} else {
				stack.push(val);
			}
		} else {
			stack.push(o2);
			stack.push(o1);
			stack.push(num);
		}
	}
	
	private boolean isNumber(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	private static final String PLUS = "+";
	private static final String MINUS = "-";
	private static final String MULTIPLY = "*";
	
	private boolean isOperator(Object o) {
		return PLUS.equals(o) || MINUS.equals(o) || MULTIPLY.equals(o);
	}
	
	private Integer evaluate(Object o1, Object o2, Object operator) {
		Integer operand1 = (Integer) o1;
		Integer operand2 = (Integer) o2;
		switch((String)operator) {
			case PLUS: return operand1 + operand2;
			case MINUS: return operand1 - operand2;
			default : return operand1 * operand2;
		}
	}
}
