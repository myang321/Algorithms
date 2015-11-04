package leetcode;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestIncreasingSubsequence i = new LongestIncreasingSubsequence();
		System.out.println(i.lengthOfLIS(new int[] {1}));

	}

	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int len = nums.length;
		int[] f = new int[len];
		int max = 0;
		Arrays.fill(f, 1);
		for (int i = 0; i < len; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (nums[j] < nums[i])
					f[i] = Math.max(f[i], f[j] + 1);
			}
			max = Math.max(max, f[i]);
		}
		return max;
	}
}
