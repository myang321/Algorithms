public class FactorialTrailingZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int trailingZeroes(int n) {
		int sum = 0;
		while (n > 0) {
			sum += n / 5;
			n /= 5;
		}
		return sum;
	}

}
