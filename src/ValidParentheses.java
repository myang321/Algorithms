import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
				stack.push(s.charAt(i));
			else if (s.charAt(i) == ')') {
				if (stack.isEmpty() || stack.pop() != '(')
					return false;
			} else if (s.charAt(i) == ']') {
				if (stack.isEmpty() || stack.pop() != '[')
					return false;
			} else if (s.charAt(i) == '}') {
				if (stack.isEmpty() || stack.pop() != '{')
					return false;
			}
		}
		return stack.isEmpty();
	}

}
