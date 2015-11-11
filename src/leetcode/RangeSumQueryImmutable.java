package leetcode;

public class RangeSumQueryImmutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumArray n = new NumArray(new int[] { -2, 0, 3, -5, 2, -1 });
		System.out.println(n.sumRange(0, 2));
		System.out.println(n.sumRange(2, 5));
		System.out.println(n.sumRange(0, 5));

	}
}

class NumArray {

	private int[] sum;

	public NumArray(int[] nums) {
		int len = nums.length;
		sum = new int[len];
		if (len == 0)
			return;
		sum[0] = nums[0];
		for (int i = 1; i < len; i++)
			sum[i] = sum[i - 1] + nums[i];
	}

	public int sumRange(int i, int j) {
		if (i == 0)
			return sum[j];
		return sum[j] - sum[i - 1];
	}
}