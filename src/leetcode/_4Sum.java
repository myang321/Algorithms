package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _4Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -3, -2, -1, 0, 0, 1, 2, 3 };
		_4Sum s = new _4Sum();
		s.fourSum(nums, 0);

	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int len = nums.length;
		Arrays.sort(nums);
		// fix i and j
		// move pointer lo and hi
		for (int i = 0; i < len - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1; j < len - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;
				int lo = j + 1;
				int hi = len - 1;
				while (lo < hi) {
					int sum = target - nums[i] - nums[j];
					int sum2 = sum - nums[lo] - nums[hi];
					if (sum2 == 0) {
						result.add(Arrays.asList(nums[i], nums[j], nums[lo],
								nums[hi]));
						while (lo + 1 < len && nums[lo] == nums[lo + 1])
							lo++;
						while (hi > 0 && nums[hi] == nums[hi - 1])
							hi--;
						lo++;
						hi--;
					} else if (sum2 > 0)
						lo++;
					else
						hi--;
				}
			}
		}
		return result;
	}
}
