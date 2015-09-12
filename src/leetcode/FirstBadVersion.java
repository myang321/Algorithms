package leetcode;
public class FirstBadVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int firstBadVersion(int n) {
		long lo = 1;
		long hi = n;
		long mid;
		// fff ttt
		while (lo < hi) {
			mid = (lo + hi) / 2;
			System.out.println(lo + " " + hi);
			System.out.println();
			// go down
			if (isBadVersion((int) mid) == true)
				hi = mid;
			// go up
			else
				lo = mid + 1;
		}
		return (int) lo;
	}

	private boolean isBadVersion(int version) {
		return true;
	}

}
