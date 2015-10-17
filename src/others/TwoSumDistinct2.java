package others;

import java.util.HashMap;
import java.util.Iterator;

public class TwoSumDistinct2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 2, 2,  3 };
		System.out.println(twoSum2(array, 6));
	}

	public static int twoSum2(int[] array, int target) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int a : array) {
			if (hm.containsKey(a))
				hm.put(a, hm.get(a) + 1);
			else
				hm.put(a, 1);
		}
		Iterator<Integer> it = hm.keySet().iterator();
		int sum = 0;
		while (it.hasNext()) {
			int a = it.next();
			if (a > target / 2)
				continue;
			int cnt = hm.get(a);
			if (a == target - a) {
				sum += cnt * (cnt - 1) / 2;
			} else {
				if (hm.containsKey(target - a))
					sum += cnt * hm.get(target - a);
			}
		}
		return sum;
	}
}
