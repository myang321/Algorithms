public class UglyNumber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UglyNumber2 u = new UglyNumber2();
		System.out.println(u.nthUglyNumber(6));

	}

	private int min3(int a, int b, int c) {
		int min2 = Math.min(a, b);
		return Math.min(min2, c);
	}

	public int nthUglyNumber(int n) {
		int cnt = 0;
		int idx2 = 0;
		int idx3 = 0;
		int idx5 = 0;
		int[] arr = new int[n];
		arr[0] = 1;
		while (++cnt != n) {
			arr[cnt] = min3(arr[idx2] * 2, arr[idx3] * 3, arr[idx5] * 5);
			// more than 1 condition can be true at the same time
			if (arr[cnt] == arr[idx2] * 2)
				idx2++;
			if (arr[cnt] == arr[idx3] * 3)
				idx3++;
			if (arr[cnt] == arr[idx5] * 5)
				idx5++;
		}
		return arr[n - 1];
	}
}
