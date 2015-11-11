package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MissingRanges m = new MissingRanges();
		System.out.println(m.findMissingRanges(new int[] { -1 }, -1, 0));
	}

	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		int len = nums.length;
		List<String> result = new ArrayList<>();
		if (len == 0) {
			result.add(getRange(lower, upper));
			return result;
		}
		if (lower < nums[0])
			result.add(getRange(lower, nums[0] - 1));
		int prev = nums[0];
		for (int i = 1; i < len; i++) {
			if (prev + 1 < nums[i]) {
				result.add(getRange(prev + 1, nums[i] - 1));
			}
			prev = nums[i];
		}
		if (nums[len - 1] < upper)
			result.add(getRange(nums[len - 1] + 1, upper));
		return result;
	}

	private String getRange(int l, int u) {
		if (l == u)
			return "" + l;
		else
			return "" + l + "->" + u;
	}

}
