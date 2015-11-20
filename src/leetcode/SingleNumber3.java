package leetcode;

public class SingleNumber3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] singleNumber(int[] nums) {
		int diff = 0;
		for (int n : nums)
			diff ^= n;
		// get right most set bit
		diff &= -diff;
		int a = 0;
		int b = 0;
		for (int n : nums) {
			if ((n & diff) == 0)
				a ^= n;
			else
				b ^= n;
		}
		return new int[] { a, b };
	}
}
