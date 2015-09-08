public class PlusOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 9 };
		plusOne(a);

	}

	public static int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i]++;
			if (digits[i] == 10) {
				digits[i] = 0;
			} else {
				return digits;
			}
		}
		int [] a = new int[digits.length+1];
		a[0]=1;
		return a;
	}

}
