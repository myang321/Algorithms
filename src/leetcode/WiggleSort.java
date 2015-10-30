package leetcode;

import java.util.Arrays;

public class WiggleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WiggleSort w = new WiggleSort();
		int[] nums = { 1, 2, 3, 4, 5 };
		w.wiggleSort(nums);
		System.out.println(Arrays.toString(nums));

	}

	// Given an unsorted array nums, reorder it in-place such that nums[0] <=
	// nums[1] >= nums[2] <= nums[3]....
	//
	// For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1,
	// 6, 2, 5, 3, 4].
	//
	// The final sorted nums needs to satisfy two conditions:
	//
	// If i is odd, then nums[i] >= nums[i - 1];
	// If i is even, then nums[i] <= nums[i - 1].
	public void wiggleSort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			boolean f1 = i % 2 == 0;
			boolean f2 = nums[i] > nums[i + 1];
			if ((f1 && f2) || (!f1 && !f2)) {
				int t = nums[i];
				nums[i] = nums[i + 1];
				nums[i + 1] = t;
			}
		}
	}
}
