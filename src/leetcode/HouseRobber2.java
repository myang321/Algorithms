package leetcode;
public class HouseRobber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HouseRobber2 hr = new HouseRobber2();
		int[] nums = { 1, 1, 1 };
		hr.rob(nums);

	}

	public int max3(int a, int b, int c) {
		return Math.max(Math.max(a, b), c);
	}

	public int rob(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return 0;
		if (len == 1)
			return nums[0];
		if (len==2)
			return Math.max(nums[0], nums[1]);
		int[] ee = new int[len];
		int[] ei = new int[len];
		int[] ie = new int[len];
		int[] ii = new int[len];
		ee[2] = nums[1];
		ei[2] = nums[2];
		ie[2] = nums[0];
		ii[2] = nums[0] + nums[2];
		for (int i = 3; i < len; i++) {
			ee[i] = Math.max(ee[i - 1], ei[i - 1]);
			ie[i] = Math.max(ie[i - 1], ii[i - 1]);
			ei[i] = ee[i - 1] + nums[i];
			ii[i] = ie[i - 1] + nums[i];
		}
		return max3(ee[len - 1], ei[len - 1], ie[len - 1]);
	}

}
