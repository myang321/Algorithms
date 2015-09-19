package leetcode;

public class MoveZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void moveZeroes(int[] nums) {
		if (nums == null)
			return;
		int idx = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[idx] = nums[i];
				if (idx != i)
					nums[i] = 0;
				idx++;

			}
		}
	}

}
