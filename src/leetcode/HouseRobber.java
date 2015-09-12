package leetcode;
public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int rob(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return 0;
		int[] f = new int[len];
		f[0] = nums[0];
		if (len == 1)
			return f[0];
		f[1] = Math.max(f[0], nums[1]);
		for (int i = 2; i < len; i++) {
			f[i] = Math.max(f[i - 1], f[i - 2] + nums[i]);
		}
		return f[len - 1];
	}
}
