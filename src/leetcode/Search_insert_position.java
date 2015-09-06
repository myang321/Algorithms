public class Search_insert_position {

	public static void main(String[] args) {
		int[] A = { 1 };
		System.out.println(searchInsert(A, 1));
	}

	public static int searchInsert(int[] A, int target) {

		if (target <= A[0])
			return 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] == target)
				return i;
			if (A[i] > target)
				return i;
		}
		return A.length;
	}

}
