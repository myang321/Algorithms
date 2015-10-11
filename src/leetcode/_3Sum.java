package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_3Sum s = new _3Sum();
		int[] num = { 0, 0, 0, 0 };
		s.threeSum(num);
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int lo = i + 1;
			int hi = nums.length - 1;
			// position i is fixed
			// lo start from left, hi start from right
			while (lo < hi) {
				int sum = nums[i] + nums[lo] + nums[hi];
				if (sum == 0) {
					result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
					while (lo < hi && nums[lo] == nums[lo + 1])
						lo++;
					while (lo < hi && nums[hi] == nums[hi - 1])
						hi--;
					lo++;
					hi--;
				} else if (sum > 0)
					hi--;
				else
					lo++;
			}
		}
		return result;
	}
}
