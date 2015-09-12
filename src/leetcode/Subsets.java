package leetcode;
import java.util.ArrayList;
import java.util.Collections;

public class Subsets {

	public static void main(String[] args) {
		Subsets s = new Subsets();
		int a[] = { 0 };
		s.subsets(a);
	}

	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> ll = new ArrayList<ArrayList<Integer>>();
		ll.add(new ArrayList<Integer>());
		ArrayList<Integer> s = new ArrayList<Integer>();
		for (int e : S)
			s.add(e);
		Collections.sort(s);
		for (Integer e : s) {
			int size = ll.size();
			for (int i = 0; i < size; i++) {
				ArrayList<Integer> tmp = new ArrayList<Integer>(ll.get(i));
				tmp.add(e);
				ll.add(tmp);
			}
		}
		return ll;
	}
}
