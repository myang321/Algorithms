package leetcode;

import java.util.Arrays;

public class TwoSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSum2 t = new TwoSum2();
		int[] nums = { 2, 7, 11, 15 };
		System.out.println(Arrays.toString(t.twoSum(nums, 9)));

	}

	// Given an array of integers that is already sorted in ascending order,
	// find two numbers such that they add up to a specific target number.
	//
	// The function twoSum should return indices of the two numbers such that
	// they add up to the target, where index1 must be less than index2. Please
	// note that your returned answers (both index1 and index2) are not
	// zero-based.
	//
	// You may assume that each input would have exactly one solution.
	//
	// Input: numbers={2, 7, 11, 15}, target=9
	// Output: index1=1, index2=2

	public int[] twoSum(int[] numbers, int target) {
		int lo = 0;
		int hi = numbers.length - 1;
		int[] result = new int[2];
		while (lo < hi) {
			if (numbers[lo] + numbers[hi] == target) {
				result[0] = lo + 1;
				result[1] = hi + 1;
				break;
			} else if (numbers[lo] + numbers[hi] < target)
				lo++;
			else
				hi--;
		}
		return result;
	}
}
