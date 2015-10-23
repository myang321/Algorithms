package leetcode;

import java.util.Arrays;

public class _3SumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Given an array S of n integers, find three integers in S such that the
	// sum is closest to a given number, target. Return the sum of the three
	// integers. You may assume that each input would have exactly one solution.
	//
	// For example, given array S = {-1 2 1 -4}, and target = 1.
	//
	// The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int max_value = num[0] + num[1] + num[2];
		for (int i = 0; i < num.length - 2; i++) {
			int j = i + 1;
			int k = num.length - 1;
			while (j < k) {
				int sum = num[i] + num[j] + num[k];
				if (Math.abs(sum - target) < Math.abs(max_value - target))
					max_value = sum;
				if (sum - target < 0) {
					j++;
				} else {
					k--;
				}
			}
		}
		return max_value;
	}
}
