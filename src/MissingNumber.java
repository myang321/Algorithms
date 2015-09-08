public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int missingNumber(int[] nums) {
		int n = nums.length;
		int sumNums = 0;
		int sumIdx = 0;
		for (int i = 0; i < n; i++) {
			sumNums += nums[i];
			sumIdx += i;
		}
		return n - (sumNums - sumIdx);
	}

}
