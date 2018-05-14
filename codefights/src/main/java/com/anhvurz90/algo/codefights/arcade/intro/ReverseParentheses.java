package com.anhvurz90.algo.codefights.arcade.intro;

public class ReverseParentheses {

	public static void main(String[] args) {
		System.out.println(new ReverseParentheses().reverseParentheses("a(bc)de"));

	}

	String reverseParentheses(String s) {
		java.util.Stack<StringBuilder> stack = new java.util.Stack<>();
		if (s.charAt(0) != '(') {
			stack.push(new StringBuilder());
		}
		for (char c : s.toCharArray()) {
			switch (c) {
			case '(':
				stack.push(new StringBuilder("("));
				stack.push(new StringBuilder());
				break;
			case ')':
				StringBuilder sb = stack.pop().reverse();
				stack.pop();
				stack.push(sb);

				System.out.println(stack.size());

				if (stack.size() > 1) {
					if (!stack.get(stack.size() - 2).toString().equals("(")) {
						String st = stack.pop().toString();
						stack.peek().append(st);
					}
				}
				break;
			default:
				stack.peek().append(c);
			}
			System.out.println(stack);
		}
		return stack.peek().toString();
	}
}
