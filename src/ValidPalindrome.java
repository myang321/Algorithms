public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPalindrome(String s) {
		String s2 = s.toLowerCase();
		char[] c1 = s2.toCharArray();
		int cnt = 0;
		for (int i = 0; i < c1.length; i++) {
			if (('0' <= c1[i] && c1[i] <= '9')
					|| ('a' <= c1[i] && c1[i] <= 'z'))
				cnt++;
		}
		char[] c2 = new char[cnt];
		for (int i = 0, j = 0; i < c1.length; i++) {
			if (('0' <= c1[i] && c1[i] <= '9')
					|| ('a' <= c1[i] && c1[i] <= 'z')) {
				c2[j] = c1[i];
				j++;
			}
		}
		int n = c2.length;
		for (int i = 0; i < n / 2; i++) {
			if (c2[i] != c2[n - i - 1])
				return false;
		}
		return true;

	}
}
