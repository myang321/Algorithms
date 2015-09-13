package microsoft;

import java.util.Stack;

public class MinStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack ms = new MinStack();
		ms.push(512);
		ms.push(-1024);
		ms.push(-1024);
		ms.push(512);
		ms.pop();
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());

	}

	private Stack<Integer> stack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();

	// push 1,2,3 to stack, only push 1 to min stack
	// push 3,2,1 to stack, push all 1,2,3 to min stack
	// only push smaller item to min stack
	public void push(int x) {
		// if x equal min, x need to be added
		if (minStack.isEmpty() || x <= minStack.peek())
			minStack.push(x);
		stack.push(x);
	}

	public void pop() {
		// do not use double equal here
		if (minStack.peek().equals(stack.peek()))
			minStack.pop();
		stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

}
