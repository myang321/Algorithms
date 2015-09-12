package leetcode;
import java.util.HashMap;

public class ContainsDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean containsDuplicate(int[] nums) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i : nums) {
			if (hm.containsKey(i))
				return true;
			hm.put(i, 1);
		}
		return false;
	}

}
