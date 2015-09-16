package leetcode;

import java.util.Stack;

public class BasicCalculator2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicCalculator2 bc2 = new BasicCalculator2();
		int re = bc2.calculate("1+2*3");
		System.out.println(re);
	}

	public int calculate(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		// the sign before the current sign
		char prevSign = '+';
		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ' ' && i != s.length() - 1)
				continue;
			if (Character.isDigit(c)) {
				num = num * 10 + (c - '0');
			}
			// only do calculation for * and /
			// push number for + and -
			if (!Character.isDigit(c) || i == s.length() - 1) {
				if (prevSign == '+') {
					stack.push(num);
				} else if (prevSign == '-') {
					stack.push(-num);
				} else if (prevSign == '*') {
					stack.push(stack.pop() * num);
				} else if (prevSign == '/') {
					stack.push(stack.pop() / num);
				}
				num = 0;
				prevSign = c;
			}
		}
		int result = 0;
		while (!stack.isEmpty()) {
			result += stack.pop();
		}
		return result;
	}
}
