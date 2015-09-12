package leetcode;
import java.util.Arrays;

public class CountPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println(countPrimes2_3(10));

	}

	public static int countPrimes(int n) {
		if (n < 3)
			return 0;
		n--;
		int len = (n + 1) / 2;
		boolean[] array = new boolean[len];
		Arrays.fill(array, false);
		int cnt = 1;
		for (int i = 1; i < len; i++) {
			if (!array[i]) {
				// System.out.println(org(i));
				cnt++;
			}
			int org_num = i * 2 + 1;
			for (int j = org_num * 3; j <= n; j += 2 * org_num) {
				array[j / 2] = true;
			}
		}
		return cnt;
	}

	public static int org(int n) {
		return n * 2 + 1;
	}

	public static int countPrimes2(int n) {
		if (n < 3)
			return 0;
		boolean[] array = new boolean[n];
		Arrays.fill(array, false);
		int cnt = 1;
		for (int i = 3; i < n; i += 2) {
			if (!array[i]) {
				// System.out.println(i+"*");
				cnt++;
				for (int j = i * 3; j < n; j += 2 * i) {
					array[j] = true;
				}
			}
		}
		return cnt;
	}

	public static int countPrimes3(int n) {
		if (n < 3)
			return 0;
		boolean[] array = new boolean[n];
		Arrays.fill(array, false);
		int cnt = 0;
		for (int i = 2; i < n; i++) {
			if (!array[i]) {
				cnt++;
				for (int j = i * 2; j < n; j += i) {
					array[j] = true;
				}
			}
		}
		return cnt;
	}

	public static int countPrimes2_2(int n) {
		if (n < 3)
			return 0;
		boolean[] array = new boolean[n];
		Arrays.fill(array, false);
		int cnt = 1;
		for (long i = 3; i < n; i += 2) {
			if (!array[(int) i]) {
				// System.out.println(i+"*");
				cnt++;
				for (long j = i * i; j < n; j += 2 * i) {
					array[(int) j] = true;
				}
			}

		}
		return cnt;
	}

	public static int countPrimes2_3(int n) {
		if (n < 3)
			return 0;
		boolean[] array = new boolean[n];
		Arrays.fill(array, false);
		long len = (long) Math.sqrt(n);
		for (long i = 3; i <= len; i += 2) {
			if (!array[(int) i]) {
				// System.out.println(i+"*");
				for (long j = i * i; j < n; j += 2 * i) {
					array[(int) j] = true;
				}
			}

		}
		int cnt = 1;
		for (int i = 3; i < n; i+=2)
			if (!array[i])
				cnt++;
		return cnt;
	}
}
