package leetcode;

public class ShortestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortestPalindrome s = new ShortestPalindrome();
		System.out.println(s.shortestPalindrome(""));

	}

	public String shortestPalindrome(String s) {
		int len = s.length();
		if (len == 0)
			return s;
		char[] arr = s.toCharArray();
		int pos = (len * 2 - 1) / 2;
		int diff = 0;
		while (pos >= 0) {
			boolean isSymm = true;
			int pos2 = pos / 2;
			if (pos % 2 == 0) {
				// char as the axis of symmetry
				for (int i = 1; pos2 - i >= 0; i++) {
					if (arr[pos2 - i] != arr[pos2 + i]) {
						isSymm = false;
						break;
					}
				}
				if (isSymm) {
					diff = len - 2 * pos2 - 1;
					break;
				}
			} else {
				// axis of symmetry is between two char
				for (int i = 0; pos2 - i >= 0; i++) {
					if (arr[pos2 - i] != arr[pos2 + i + 1]) {
						isSymm = false;
						break;
					}
				}
				if (isSymm) {
					diff = len - 2 * pos2 - 2;
					break;
				}
			}
			pos--;
		}
		String s2 = new StringBuffer(s.substring(len - diff)).reverse() + s;
		return s2;
	}
}
