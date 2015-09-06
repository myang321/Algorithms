import java.util.Stack;

public class MinStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// MinStack ms = new MinStack();
		// ms.push(3);
		// ms.push(1);
		// ms.push(2);
		// for (int i = 0; i < 3; i++) {
		// System.out.println("min=" + ms.getMin());
		// ms.pop();
		// System.out.println();
		// }
		Stack<Integer> s = new Stack<Integer>();
		s.push(5);
		Integer i1 = s.pop();
		s.push(3);
		Integer i2 = s.pop();
		System.out.println(i1.hashCode());
		System.out.println(i2.hashCode());
	}

	public Stack<Integer> stack = new Stack<Integer>();
	public Stack<Integer> stackMin = new Stack<Integer>();

	public void push(int x) {
		stack.push(x);
		if (stackMin.isEmpty())
			stackMin.push(x);
		else if (stackMin.peek() >= x)
			stackMin.push(x);
	}

	public void pop() {
		if (stack.peek().equals(stackMin.peek()))
			stackMin.pop();
		stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return stackMin.peek();
	}

}
