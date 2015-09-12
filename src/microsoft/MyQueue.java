package microsoft;

public class MyQueue {

	public static void main(String[] args) throws Exception {
		MyQueue q = new MyQueue(3);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}

	// using array to implement queue
	private int[] array;
	private int in, out;
	private int size;

	public MyQueue(int size) {
		array = new int[size];
		in = 0;
		out = 0;
		this.size = size;
	}

	public int dequeue() throws Exception {
		if (isEmpty()) {
			throw new Exception("cannot dequeue, queue is empty");
		}
		int val = array[out % size];
		out++;
		return val;
	}

	// return true if successful enqueue
	public boolean enqueue(int val) {
		if (isFull())
			return false;
		array[in % size] = val;
		in++;
		return true;
	}

	public boolean isEmpty() {
		return in == out;
	}

	public boolean isFull() {
		return (in - out) == size;
	}
}
