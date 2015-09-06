public class MultiplyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "123";
		String s2 = "456";
		multiply(s1, s2);
	}

	public static String multiply(String num1, String num2) {
		int len1 = num1.length();
		int len2 = num2.length();
		num1 = new StringBuffer(num1).reverse().toString();
		num2 = new StringBuffer(num2).reverse().toString();
		int[] arr = new int[len1 + len2];
		int carry = 0;
		int n1, n2;
		for (int i = 0; i < len1; i++) {
			carry = 0;
			for (int j = 0; j < len2; j++) {
				n1 = num1.charAt(i) - '0';
				n2 = num2.charAt(j) - '0';
				arr[i + j] += n1 * n2;
			}
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < len1 + len2; i++) {
			arr[i] += carry;
			carry = arr[i] / 10;
			arr[i] %= 10;
			sb.append(arr[i]);
		}
		while (sb.charAt(sb.length() - 1) == '0' && sb.length() > 1) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.reverse().toString();
	}
}
