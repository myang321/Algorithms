public class SearchforaRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] searchRange(int[] A, int target) {
		int[] result = new int[2];
		result[0] = -1;
		result[1] = -1;
		if (A == null || A.length == 0)
			return result;
		int lo = 0;
		int hi = A.length - 1;
		while (lo + 1 < hi) {
			int mid = (lo + hi) / 2;
			if (A[mid] == target)
				hi = mid;
			else if (A[mid] > target)
				hi = mid - 1;
			else
				lo = mid + 1;
		}
		if (A[lo] == target)
			result[0] = lo;
		else if (A[hi] == target)
			result[0] = hi;
		else {
			return result;
		}
		// ///////////////////
		lo = 0;
		hi = A.length - 1;
		while (lo + 1 < hi) {
			int mid = (lo + hi) / 2;
			if (A[mid] == target)
				lo = mid;
			else if (A[mid] > target)
				hi = mid - 1;
			else
				lo = mid + 1;
		}
		if (A[hi] == target)
			result[1] = hi;
		else if (A[lo] == target)
			result[1] = lo;
		else {
			return result;
		}
		return result;

	}

}
