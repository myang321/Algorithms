package leetcode;

import java.util.HashSet;
import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> hs = new HashSet<Integer>();
		// hs.add(1);
		Iterator<Integer> it = hs.iterator();

	}

	private Iterator<Integer> iterator;
	private Integer nextInt;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		this.iterator = iterator;
		nextInt = null;
	}

	// Returns the next element in the iteration without advancing the iterator.
	// throw exception when empty
	public Integer peek() {
		if (nextInt == null)
			nextInt = iterator.next();
		return nextInt;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if (nextInt != null) {
			Integer tmp = nextInt;
			nextInt = null;
			return tmp;
		}
		return iterator.next();
	}

	@Override
	public boolean hasNext() {
		if (nextInt != null)
			return true;
		return iterator.hasNext();
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}
}
