package leetcode;

import java.util.Arrays;

public class PerfectSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numSquares(int n) {
		// f[i] means the min squares for number i
		int[] f = new int[n + 1];
		Arrays.fill(f, Integer.MAX_VALUE);
		f[0] = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j * j <= i; j++) {
				f[i] = Math.min(f[i], f[i - j * j] + 1);
			}
		}
		return f[n];
	}
}
