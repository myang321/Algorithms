package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MajorityElement2 me = new MajorityElement2();
		int[] nums = { 1,2,3 };
		System.out.println(me.majorityElement(nums));

	}

	public List<Integer> majorityElement(int[] nums) {
		int len = nums.length;
		int num1 = 0, num2 = 0;
		int cnt1 = 0, cnt2 = 0;
		for (int n : nums) {
			if (cnt1 == 0 || n == num1) {
				cnt1++;
				num1 = n;
			} else if (cnt2 == 0 || n == num2) {
				cnt2++;
				num2 = n;
			} else {
				cnt1--;
				cnt2--;
			}
		}
		// still need to check again
		cnt1 = cnt2 = 0;
		for (int n : nums) {
			if (n == num1)
				cnt1++;
			else if (n == num2)
				cnt2++;
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (cnt1 > len / 3)
			result.add(num1);
		if (cnt2 > len / 3)
			result.add(num2);
		return result;
	}
}
