package leetcode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class Subsets2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 1, 1 };
		subsetsWithDup(a);

	}

	public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int e : num)
			arr.add(e);
		Collections.sort(arr);
		ArrayList<ArrayList<Integer>> ll = new ArrayList<ArrayList<Integer>>();
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
		HashSet<ArrayList<Integer>> hl = new HashSet<ArrayList<Integer>>();
		for (ArrayList<Integer> l : ll) {
			hl.add(l);
		}
		ll.clear();
		for (ArrayList<Integer> l : hl) {
			ll.add(l);
		}
		return ll;
	}
}
