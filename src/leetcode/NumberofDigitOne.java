package leetcode;
public class NumberofDigitOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberofDigitOne nd = new NumberofDigitOne();
		System.out.println(nd.countDigitOne(110));
	}

	private long[] f;
	private long result;
	private int[] preOne;
	boolean[] isOne;

	// n=89763
	// step 1: count one in [0,79999]
	// step 2: count one in [80000,88999]
	// step 3: count one in [89000,89699]
	// step 4: count one in [89700,89759]
	// last step not in loop: count one in [89760, 89763]
	public int countDigitOne(int n) {
		getF();
		getPreOne(n);
		int tmp_n = 0;
		// 999'999'999
		int base = 999999999;
		// index for f[]
		int base_idx = 8;
		while (tmp_n + 9 <= n) {
			// System.out.println("tmp_n:" + tmp_n);
			while (tmp_n + base > n) {
				base /= 10;
				base_idx--;
			}
			// System.out.println("base:" + base);
			tmp_n = getCount(tmp_n, n, base, base_idx);
		}
		// count for the last digit
		if (n % 10 != 9) {
			if (isOne[1])
				result += (n - tmp_n + 1) * (preOne[0] + 1);
			else
				result += (n - tmp_n + 1) * preOne[0];
		}
		// last digit [1,8]
		if ((n % 10) % 9 > 0)
			result++;
		return (int) result;
	}

	// count the ones in [0,k*base<end]
	// k in [0,9]
	private int getCount(int start, int end, int base, int base_idx) {
		long cnt = 0;
		int oldStart = start;
		for (int i = 0; start + base <= end; i++, start += base + 1) {
			// System.out.println("start:" + start);
			cnt += f[base_idx];
			if (i == 1)
				cnt += base + 1;
			if (oldStart != 0)
				cnt += preOne[base_idx] * (base + 1);
		}
		result += cnt;
		return start;
	}

	private void getF() {
		// f[0]=one in [0,9]
		// f[1]=one in [0,99]
		f = new long[9];
		f[0] = 1;
		long d = 10;
		for (int i = 1; i < f.length; i++) {
			f[i] = f[i - 1] * 10 + d;
			d *= 10;
			// System.out.println(i + " " + f[i]);
		}
	}

	private void getPreOne(int n) {
		// n=131241
		// preOne={2,2,1,1,0,0}
		// preOne[0]=one in {1,3,1,2} exclude last 2 digit
		// preOne[1]=one in {1,3,1} exclude last 3 digit
		preOne = new int[9];
		isOne = new boolean[10];
		int i = 0;
		while (n > 0) {
			isOne[i] = false;
			if (n % 10 == 1)
				isOne[i] = true;
			n /= 10;
			i++;
		}
		preOne[8] = 0;
		if (isOne[9])
			preOne[7] = 1;
		for (int j = 6; j >= 0; j--) {
			preOne[j] = preOne[j + 1];
			if (isOne[j + 2])
				preOne[j]++;
		}
	}
}
