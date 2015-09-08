public class DivideTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DivideTwoIntegers d = new DivideTwoIntegers();
		System.out.println(d.divide(-2147483648, -1));
	}

	public int divide(int dividend, int divisor) {
		boolean isNage = false;
		if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0)
			isNage = true;
		long a = Math.abs((long) dividend);
		long b = Math.abs((long) divisor);
		long sum = 0;
		long one = 1;
		while (a >= b) {
			int shift = 0;
			while ((b << shift) <= a)
				shift++;
			shift--;
			a -= (b << shift);
			sum += one << shift;
		}
		if (sum > Integer.MAX_VALUE && !isNage)
			return Integer.MAX_VALUE;
		int sum2 = (int) sum;
		return isNage ? -sum2 : sum2;
	}

	public int divide2(int dividend, int divisor) {
		boolean negative = (dividend > 0 && divisor < 0)
				|| (dividend < 0 && divisor > 0);

		long a = Math.abs((long) dividend);
		long b = Math.abs((long) divisor);
		int ans = 0;

		while (a >= b) {
			int shift = 0;
			while ((b << shift) <= a) {
				shift++;
			}
			ans += 1 << (shift - 1);
			a = a - (b << (shift - 1));
		}

		return negative ? -ans : ans;
	}

}
