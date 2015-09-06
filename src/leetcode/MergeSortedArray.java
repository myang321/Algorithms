public class MergeSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void merge(int A[], int m, int B[], int n) {

		for (int i = m + n - 1; i >= 0; i--) {
			if (m == 0) {
				A[i] = B[n - 1];
				n--;
			} else if (n == 0) {
				break;
			} else if (A[m - 1] > B[n - 1]) {
				A[i] = A[m - 1];
				m--;
			} else {
				A[i] = B[n - 1];
				n--;
			}

		}
	}

}
