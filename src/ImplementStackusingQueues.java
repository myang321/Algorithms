import java.util.LinkedList;

public class ImplementStackusingQueues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementStackusingQueues s = new ImplementStackusingQueues();
		s.push(1);
		s.push(2);
		System.out.println(s.top());

	}

	private LinkedList<Integer> queue1 = new LinkedList<Integer>();
	private LinkedList<Integer> queue2 = new LinkedList<Integer>();

	// Push element x onto stack.
	public void push(int x) {
		System.out.println("start push");
		while (queue1.isEmpty() == false) {
			queue2.add(queue1.pop());
		}
		queue1.add(x);
		System.out.println("push " + x);
		while (queue2.isEmpty() == false) {
			System.out.println("push " + queue2.peek());
			queue1.add(queue2.pop());
		}
	}

	// Removes the element on top of the stack.
	public void pop() {
		queue1.pop();

	}

	// Get the top element.
	public int top() {
		return queue1.peek();

	}

	// Return whether the stack is empty.
	public boolean empty() {
		return queue1.isEmpty();
	}
}
