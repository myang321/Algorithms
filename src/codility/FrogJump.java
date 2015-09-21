package codility;

public class FrogJump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
		for (int i = 0; i < A.length; i++) {
			mark[A[i]] = true;
			if (A[i] <= maxReachable && A[i] > curPos) {
				int prevMaxReachable = maxReachable;
				curPos = A[i];
				maxReachable = A[i] + D;
				int j = prevMaxReachable + 1;
				// each position in mark will only be visited once
				while (j <= maxReachable && j < X) {
					if (mark[j]) {
						maxReachable = j + D;
					}
					j++;
				}
			}
			if (maxReachable >= X)
				return i;
		}
		return -1;
	}
}
