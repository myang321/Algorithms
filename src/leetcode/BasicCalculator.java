package leetcode;

import java.util.Stack;

public class BasicCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "(1+(4+5+2)-3)+(6+8)";
		System.out.println(calculate(str));
	}

	public static int calculate(String s) {
		Stack<Integer> resultStack = new Stack<Integer>();
		Stack<Integer> signStack = new Stack<Integer>();
		int result = 0;
		int sign = 1;
		int number = 0;
		for (char c : s.toCharArray()) {
			if (c >= '0' && c <= '9') {
				number = number * 10 + (c - '0');
			} else if (c == '+') {
				// add the number before the sign
				result += sign * number;
				sign = 1;
				number = 0;
			} else if (c == '-') {
				// add the number before the sign
				result += sign * number;
				sign = -1;
				number = 0;
			} else if (c == '(') {
				signStack.push(sign);
				resultStack.push(result);
				result = 0;
				sign = 1;
			} else if (c == ')') {
				result += sign * number;
				result *= signStack.pop();
				result += resultStack.pop();
				number = 0;
				sign = 1;
			}
		}
		if (number != 0)
			result += sign * number;
		return result;
	}
}
