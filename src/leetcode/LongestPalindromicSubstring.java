package leetcode;
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ccc";
		System.out.println(longestPalindrome(s));
	}

	public static String longestPalindrome(String s) {
		char[] c = s.toCharArray();
		int len = s.length();
		while (len > 0) {
			int i, start = 0;
			while (start + len <= s.length()) {
				for (i = 0; i < len / 2; i++) {
					if (c[i + start] != c[len - i - 1 + start])
						break;
				}
				if (i == len / 2) {
					return s.substring(start, start + len);
				}
				start++;
			}
			len--;
		}
		return s.substring(0, 1);
	}
}
