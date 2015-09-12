package leetcode;
import java.util.Stack;

public class ImplementQueueusingStacks {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		ImplementQueueusingStacks q = new ImplementQueueusingStacks();
		q.push(1);
		q.push(2);
		q.pop();
		System.out.println(q.peek());

	}

	private Stack<Integer> stack = new Stack<Integer>();

	// Push element x to the back of queue.
	public void push(int x) {
		if (stack.isEmpty() == false) {
			Stack<Integer> stack2 = new Stack<Integer>();
			while (stack.isEmpty() == false) {
				stack2.push(stack.pop());
			}
			stack.push(x);
			while (stack2.isEmpty() == false) {
				stack.push(stack2.pop());
			}
		} else {
			stack.push(x);
		}
	}

	// Removes the element from in front of queue.
	public void pop() {
		stack.pop();
	}

	// Get the front element.
	public int peek() {
		return stack.peek();

	}

	// Return whether the queue is empty.
	public boolean empty() {
		return stack.isEmpty();

	}

}
