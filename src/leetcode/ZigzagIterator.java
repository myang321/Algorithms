package leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ZigzagIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Given two 1d vectors, implement an iterator to return their elements
	// alternately.
	//
	// For example, given two 1d vectors:
	//
	// v1 = [1, 2]
	// v2 = [3, 4, 5, 6]
	// By calling next repeatedly until hasNext returns false, the order of
	// elements returned by next should be: [1, 3, 2, 4, 5, 6].
	//
	// Follow up: What if you are given k 1d vectors? How well can your code be
	// extended to such cases?
	//
	// Update: when k vectors are provided, what the results should be still
	// remain to be a question (you may refer to this post). So the following
	// notes do not focus on that now.
	private LinkedList<Iterator> list;

	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		list = new LinkedList<Iterator>();
		if (v1.size() > 0)
			list.add(v1.iterator());
		if (v2.size() > 0)
			list.add(v2.iterator());

	}

	public int next() {
		Iterator<Integer> it = list.remove();
		int nextVal = it.next();
		// add it at the last of the queue
		if (it.hasNext())
			list.add(it);
		return nextVal;
	}

	public boolean hasNext() {
		return !list.isEmpty();
	}

}
