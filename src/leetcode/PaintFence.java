package leetcode;

public class PaintFence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//
	// There is a fence with n posts, each post can be painted with one of the k
	// colors.
	//
	// You have to paint all the posts such that no more than two adjacent fence
	// posts have the same color.
	//
	// Return the total number of ways you can paint the fence.
	//
	// Note:
	// n and k are non-negative integers.

	public int numWays(int n, int k) {
		if (n == 0 || k == 0)
			return 0;
		if (n == 1)
			return k;
		// start from f(2)
		int same = k;
		int diff = k * k - k;
		n -= 2;
		while (n-- > 0) {
			int prevDiff = diff;
			diff = same * (k - 1) + diff * (k - 1);
			same = prevDiff;
		}
		return same + diff;
	}

}
