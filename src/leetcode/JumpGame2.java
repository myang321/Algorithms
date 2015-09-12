package leetcode;
import java.util.Arrays;

public class JumpGame2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr={0};
		System.out.println(jump2(arr));
	}

	public static int jump(int[] A) {
		if (A == null || A.length <= 1)
			return 0;
		int begin = 1;
		int tail = A[0];
		int len = A.length;
		int cnt = 1;
		while (tail < len - 1) {
			int maxPace = 0;
			for (int i = begin; i <= tail; i++) {
				maxPace = Math.max(maxPace, i + A[i]);
			}
			begin = tail + 1;
			tail = maxPace;
			cnt++;
		}
		return cnt;
	}

	public static int jump2(int[] A) {
		if (A == null || A.length <= 1) {
			return 0;
		}

		int tail = A[0];
		int min = 1;
		int begin = 0;
		while (tail < A.length - 1) {
			int maxPace = 0;
			for (int i = begin; i <= tail; i++) {
				maxPace = Math.max(maxPace, i + A[i]);
			}
			begin = tail + 1;
			tail = Math.max(tail, maxPace);
			min++;
		}
		return min;
	}
}
