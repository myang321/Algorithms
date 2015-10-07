package leetcode;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindromicSubstring l = new LongestPalindromicSubstring();
		String s = "abcba";
		System.out.println(l.longestPalindrome(s));
	}


	public String longestPalindrome(String s) {
		if (s.isEmpty())
			return "";
		if (s.length() == 1)
			return s;
		int len = s.length();
		int begin, end;
		int max_len = 1;
		int begin_idx = 0;
		for (int i = 0; i < len;) {
			begin = i;
			end = i;
			while (end + 1 < len && s.charAt(end) == s.charAt(end + 1))
				end++;
			i = end + 1;
			while (end + 1 < len && begin - 1 >= 0
					&& s.charAt(begin - 1) == s.charAt(end + 1)) {
				begin--;
				end++;
			}
			if (end - begin + 1 > max_len) {
				max_len = end - begin + 1;
				begin_idx = begin;
			}
		}
		return s.substring(begin_idx, begin_idx + max_len);
	}
}
