public class ImplementstrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "mississippi";
		String s2 = "issip";
		strStr(s1, s2);
	}

	public static String strStr(String haystack, String needle) {
		if (haystack == null || needle == null)
			return null;
		if (needle.length() == 0)
			return haystack;
		int i = 0;
		int j = 0;
		while (i < haystack.length() && j < needle.length()) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				j++;
				i++;
			} else {
				i = i - j + 1;
				j = 0;
				continue;
			}
			if (j == needle.length())
				return haystack.substring(i - j);
		}
		return null;
	}
}
