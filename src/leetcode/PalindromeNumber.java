public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isPalindrome(11);
	}

	public static boolean isPalindrome(int x) {
		if (x<0)
			return false;
		int y = 0, tmpx = x;

		while (x != 0) {
			y *= 10;
			y += x % 10;
			x /= 10;
		}
		return tmpx == y;
	}
}
