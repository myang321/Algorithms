package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Subsets2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 1, 1 };
		Subsets2 ss = new Subsets2();
		ss.subsetsWithDup(a);

	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int e : nums)
			arr.add(e);
		Collections.sort(arr);
		ArrayList<List<Integer>> ll = new ArrayList<List<Integer>>();
		//
		ll.add(new ArrayList<Integer>());
		for (Integer e : arr) {
			int sz = ll.size();
			for (int i = 0; i < sz; i++) {
				ArrayList<Integer> tmp = new ArrayList<Integer>(ll.get(i));
				tmp.add(e);
				ll.add(tmp);
			}
		}
		HashSet<List<Integer>> hl = new HashSet<List<Integer>>();
		for (List<Integer> l : ll) {
			hl.add(l);
		}
		ll.clear();
		for (List<Integer> l : hl) {
			ll.add(l);
		}
		return ll;
	}
}
