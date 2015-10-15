package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationSequence p = new PermutationSequence();
		System.out.println(p.getPermutation(4, 14));
	}

	public String getPermutation(int n, int k) {
		StringBuffer result = new StringBuffer();
		int fac = 1;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
			fac *= i;
		}
		fac /= n;
		k--;
		for (int i = n - 1; i > 0; i--) {
			int idx = k / fac;
			result.append(list.get(idx));
			list.remove(idx);
			k -= fac * idx;
			fac /= i;

		}
		result.append(list.get(0));
		return result.toString();
	}
}
