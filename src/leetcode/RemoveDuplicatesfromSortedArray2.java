public class RemoveDuplicatesfromSortedArray2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = { 1 };
		removeDuplicates(a);
	}

	public static int removeDuplicates(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		int index = 0;
		int cnt = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[index] == A[i]) {
				if (cnt == 1) {
					index++;
					A[index] = A[i];
					cnt++;
				} else if (cnt == 0) {
					cnt = 1;
				} else
					continue;

			} else {
				index++;
				A[index] = A[i];
				cnt = 1;
			}
		}
		return index + 1;
	}

}
