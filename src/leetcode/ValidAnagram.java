package leetcode;
public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isAnagram(String s, String t) {
		if (s.length()!=t.length())
			return false;
		int[] array = new int[26];
		for (char c : s.toCharArray())
			array[c - 'a']++;
		for (char c : t.toCharArray()) {
			array[c - 'a']--;
			if (array[c - 'a'] < 0)
				return false;
		}
		return true;
	}
}
