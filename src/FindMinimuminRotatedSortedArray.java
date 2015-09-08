public class FindMinimuminRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 1 };
		System.out.println(findMin(arr));
	}

	public int findMin1(int[] num) {
		int n = num[0];
		for (int e : num) {
			if (e < n)
				return e;
		}
		return n;
	}


	public static int findMin(int[] num) {
		int start = 0;
		int end = num.length - 1;
		while (start < end) {
			if (num[start] < num[end])
				return num[start];
			int mid = (start + end) / 2;
			if (num[start] <= num[mid]) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return num[start];
	}

	public static int findMin2(int[] num) {
		int start = 0, end = num.length - 1;

		while (start < end) {
			if (num[start] < num[end])
				return num[start];

			int mid = (start + end) / 2;

			if (num[mid] >= num[start]) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}

		return num[start];
	}

}
