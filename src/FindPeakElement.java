public class FindPeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindPeakElement fpe = new FindPeakElement();
		int[] nums = { 1 };
		System.out.println(fpe.findPeakElement(nums));

	}

	public int findPeakElement(int[] nums) {
		int len = nums.length;
		if (len == 1)
			return 0;
		return helper(nums, 0, len - 1);
	}

	private int helper(int[] nums, int lo, int hi) {
		int mid = lo + (hi - lo) / 2;
		System.out.println("lo=" + lo);
		System.out.println("hi=" + hi);
		int len = nums.length;
		if (mid == 0) {
			if (nums[0] > nums[1])
				return mid;
		} else if (mid == len - 1) {
			if (nums[len - 1] > nums[len - 2])
				return mid;
		} else if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1])
			return mid;
		if (nums[mid] < nums[mid + 1])
			return helper(nums, mid + 1, hi);
		else
			return helper(nums, lo, mid - 1);
	}

}
