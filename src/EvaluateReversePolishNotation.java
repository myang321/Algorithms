import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] ss = { "-4", "3", "+" };
		System.out.println(evalRPN3(ss));

	}

	public static int evalRPN(String[] tokens) {
		Stack<Integer> s = new Stack<Integer>();
		int num = 0, n1, n2;
		char op;
		for (int i = 0; i < tokens.length; i++) {
			String str = tokens[i];
			if (str.matches("-?\\d+")) {
				num = Integer.parseInt(str);
				s.push(num);
			} else {
				op = str.charAt(0);
				n2 = s.pop();
				n1 = s.pop();
				if (op == '+') {
					num = n1 + n2;
				} else if (op == '-') {
					num = n1 - n2;
				} else if (op == '*') {
					num = n1 * n2;
				} else if (op == '/') {
					num = n1 / n2;
				}
				s.push(num);
			}
		}
		return s.pop();
	}

	private static final Set OPERATORS = new HashSet<>(Arrays.asList("+", "-",
			"*", "/"));

	public static int evalRPN2(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for (String token : tokens) {
			if (OPERATORS.contains(token)) {
				int y = stack.pop();
				int x = stack.pop();
				stack.push(eval(x, y, token));
			} else {
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}

	private static int eval(int x, int y, String operator) {
		switch (operator) {
		case "+":
			return x + y;
		case "-":
			return x - y;
		case "*":
			return x * y;
		default:
			return x / y;
		}
	}
	
	 public static int evalRPN3(String[] tokens) {
	        Stack<Integer> store=new Stack<Integer>();
	        int sum=0;
	        for(int i=0;i<tokens.length;i++){
	        	if(!tokens[i].matches("-?\\d+")){
	        		int a=store.pop();
	        		int b=store.pop();
	          		if(tokens[i]=="+"){
	        			sum=b+a;
	        		}
	        		else if(tokens[i]=="-"){
	        			sum=b-a;
	        		}
	        		else if(tokens[i]=="*"){
	        			sum=b*a;
	        		}
	        		else if(tokens[i]=="/"){
	        			sum=b/a;
	        		}
	        		store.push(sum);
	        	}
	        	else{
	        		store.push(Integer.parseInt(tokens[i]));
	        	}
	        }
	        return store.pop();
	    }
}
