public class ProductofArrayExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		int[] array1 = new int[len];
		int[] array2 = new int[len];
		int[] sum = new int[len];
		array1[0] = nums[0];
		array2[len - 1] = nums[len - 1];
		for (int i = 1; i < len; i++)
			array1[i] = array1[i - 1] * nums[i];
		for (int i = len - 2; i >= 0; i--)
			array2[i] = array2[i + 1] * nums[i];
		sum[0] = array2[1];
		sum[len - 1] = array1[len - 2];
		for (int i = 1; i < len - 1; i++)
			sum[i] = array1[i - 1] * array2[i + 1];
		return sum;
	}
}
