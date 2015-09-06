public class SearchinRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1 };
		System.out.println(search(arr, 0));
	}

	public static int search2(int[] A, int target) {
		int start = 0;
		int end = A.length - 1;
		while (start < end) {
			if (A[start] < A[end])
				break;
			int mid = (start + end) / 2;
			if (A[start] <= A[mid])
				start = mid + 1;
			else
				end = mid;
		}
		int rot = start;
		int lo = 0 + rot;
		int hi = (A.length - 1 + rot) % A.length;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			mid %= A.length;
			if (target == A[mid])
				return mid;
			if (target > A[mid])
				lo = (mid + 1);
			else
				hi = (mid - 1);
		}
		return -1;
	}

	public static int search(int[] A, int target) {
		int start = 0;
		int end = A.length - 1;
		while (start < end) {
			if (A[start] < A[end])
				break;
			int mid = (start + end) / 2;
			if (A[start] <= A[mid])
				start = mid + 1;
			else
				end = mid;
		}
		int rot = start;
		int lo = 0;
		int hi = A.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			int realMid = (mid + rot) % A.length;
			if (target == A[realMid])
				return realMid;
			if (target > A[realMid])
				lo = mid + 1;
			else
				hi = mid - 1;
		}
		return -1;
	}
}
