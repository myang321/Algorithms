package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class LongestValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestValidParentheses l = new LongestValidParentheses();
		l.longestValidParentheses("(()");

	}

	public int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		char[] c = s.toCharArray();
		// pair out all valid
		for (int i = 0; i < c.length; i++) {
			if (c[i] == '(') {
				stack.push(i);
			} else {
				if (stack.isEmpty()) {
					stack.push(i);
				} else {
					int idx = stack.peek();
					if (c[idx] == '(')
						stack.pop();
					else
						stack.push(i);
				}
			}
		}
		int prevIdx = c.length;
		int max = 0;
		if (stack.isEmpty())
			return c.length;
		// find the longest gap
		while (!stack.isEmpty()) {
			int idx = stack.pop();
			max = Math.max(max, prevIdx - idx - 1);
			prevIdx = idx;
		}
		// from begin
		max = Math.max(max, prevIdx);
		return max;
	}
}
