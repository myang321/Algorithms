package leetcode;

import java.util.Arrays;

public class _3Sum_Smaller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_3Sum_Smaller s = new _3Sum_Smaller();
		int[] nums = { 0, 1, -2, 3, -1 };
		System.out.println(s.threeSumSmaller(nums, 2));
	}

	// Given an array of n integers nums and a target, find the number of index
	// triplets i, j, k with 0 <= i < j < k < n that satisfy the condition
	// nums[i] + nums[j] + nums[k] < target.
	//
	// For example, given nums = [-2, 0, 1, 3], and target = 2.
	//
	// Return 2. Because there are two triplets which sums are less than 2:
	//
	// [-2, 0, 1]
	// [-2, 0, 3]
	// Follow up:
	// Could you solve it in O(n^2) runtime?

	public int threeSumSmaller(int[] nums, int target) {
		Arrays.sort(nums);
		int cnt = 0;
		int len = nums.length;
		for (int i = 0; i < len - 2; i++) {
			int j = i + 1;
			int k = len - 1;
			while (j < k) {
				// only count between j and k
				// count k from [j+1,k]
				// don't need to count between i and j, because j does not go
				// backward
				if (nums[i] + nums[j] + nums[k] < target) {
					cnt += k - j;
					j++;
				} else
					k--;
			}
		}
		return cnt;
	}
}
