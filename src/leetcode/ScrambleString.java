package leetcode;

public class ScrambleString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScrambleString ss = new ScrambleString();
		String s1 = "ab";
		String s2 = "ba";
		System.out.println(ss.isScramble(s1, s2));

	}

	public boolean isScramble(String s1, String s2) {
		if (s1.equals(s2))
			return true;
		if (!countAlphabet(s1, s2))
			return false;
		int len = s1.length();
		for (int i = 1; i < len; i++) {
			// s1 left vs s2 left,s1 right vs s2 right
			if (isScramble(s1.substring(0, i), s2.substring(0, i))
					&& isScramble(s1.substring(i), s2.substring(i)))
				return true;
			// s1 left vs s2 right, s1 right vs s2 left
			if (isScramble(s1.substring(0, i), s2.substring(len - i))
					&& isScramble(s1.substring(i), s2.substring(0, len - i)))
				return true;
		}
		return false;
	}

	// should have same number of each letter
	private boolean countAlphabet(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		int[] arr1 = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			arr1[s1.charAt(i) - 'a']++;
			arr1[s2.charAt(i) - 'a']--;
		}
		for (int i = 0; i < 26; i++) {
			if (arr1[i] != 0)
				return false;
		}
		return true;
	}
}
