package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSum3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSum_ t = new TwoSum_();
		t.add(1);
		t.add(2);
		System.out.println(t.find(3));

	}

	// Design and implement a TwoSum class. It should support the following
	// operations: add and find.
	//
	// add - Add the number to an internal data structure.
	// find - Find if there exists any pair of numbers which sum is equal to the
	// value.
	//
	// For example,
	// add(1); add(3); add(5);
	// find(4) -> true
	// find(7) -> false

}

class TwoSum_ {

	private HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	private List<Integer> list = new ArrayList<>();

	// Add the number to an internal data structure.
	public void add(int number) {
		if (hm.containsKey(number))
			// no need for actual number,minimize function call
			hm.put(number, 2);
		else {
			hm.put(number, 1);
			list.add(number);
		}
	}

	// Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
		// sequential scan arraylist is much faster than iterate hashmap
		for (int key1 : list) {
			int key2 = value - key1;
			if (hm.containsKey(key2)) {
				// if value=key1*2, cnt>1
				if (key2 != key1 || hm.get(key2) > 1)
					return true;
			}
		}
		return false;
	}
}
