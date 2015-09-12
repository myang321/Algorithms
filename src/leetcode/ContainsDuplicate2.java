package leetcode;
import java.util.HashSet;

public class ContainsDuplicate2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 1 };
		containsNearbyDuplicate(nums, 1);
	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (hs.contains(nums[i]))
				return true;
			hs.add(nums[i]);
			if (i >= k)
				hs.remove(nums[i - k]);
		}
		return false;
	}
}
