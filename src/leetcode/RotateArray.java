package leetcode;
public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateArray ra = new RotateArray();
		int[] nums = { 1, 2, 3 };
		ra.rotate(nums, 2);

	}

	public void rotate(int[] nums, int k) {
		int len = nums.length;
		k = k % len;
		reverse(nums, 0, len - k);
		reverse(nums, len - k, len);
		reverse(nums, 0, len);
	}

	private void reverse(int[] nums, int start, int end) {
		int mid = (start + end) / 2;
		for (int i = start, j = 1; i < mid; i++, j++) {
			int temp = nums[i];
			nums[i] = nums[end - j];
			nums[end - j] = temp;
		}
	}
}
