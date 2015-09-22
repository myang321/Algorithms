package codility;

public class FrogJump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrogJump t = new FrogJump();
		int[] data = { 1, 3, 1, 4, 2, 5 };
		System.out.println(t.solution(data, 7, 3));

	}

	// X: pond length
	// D: frog max jump range
	// A: index is the time, value is the position of the leave
	// A[k]=p, at time k, leaf falls in position p
	// frog init position 0, need to get to other side of pond, position X
	// frog jump takes no time, find the minimum time
	public int solution(int[] A, int X, int D) {
		boolean[] mark = new boolean[X];
		int maxReachable = D;
		int curPos = 0;
		// each position in A will only be visited once
		// idx for mark array
		int idx = maxReachable;
		for (int i = 0; i < A.length; i++) {
			mark[A[i]] = true;
			if (A[i] <= maxReachable && A[i] > curPos) {
				curPos = A[i];
				maxReachable = A[i] + D;
				// each position in mark will only be visited once
				while (idx <= maxReachable && idx < X) {
					if (mark[idx]) {
						maxReachable = idx + D;
					}
					idx++;
				}
			}
			if (maxReachable >= X)
				return i;
		}
		return -1;
	}
}
