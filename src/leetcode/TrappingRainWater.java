public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int trap(int[] A) {
		if (A.length==0)
			return 0;
		int B[] = new int[A.length];
		int max = -1;
		for (int i = A.length - 1; i >= 0; i--) {
			B[i] = max;
			max = Math.max(max, A[i]);
		}
		int start = Math.min(A[0], B[0]);
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] >= start) {
				start = Math.min(A[i], B[i]);
			} else {
				sum += start - A[i];
			}
		}
		return sum;
	}
}
