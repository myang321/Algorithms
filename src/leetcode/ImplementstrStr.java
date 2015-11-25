package leetcode;

public class ImplementstrStr {

	static int cnt = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "msadvasdvasvsaississippi";
		String s2 = "issip";
		ImplementstrStr i = new ImplementstrStr();
		System.out.println(i.strStr2(s1, s2));
		System.out.println("cnt:" + cnt);
	}

	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null)
			return -1;
		if (needle.length() == 0)
			return 0;
		int i = 0;
		int j = 0;
		int i_begin = i;
		while (i < haystack.length() && j < needle.length()) {
			cnt++;
			if (haystack.charAt(i) == needle.charAt(j)) {
				j++;
				i++;
			} else {
				i_begin++;
				i = i_begin;
				j = 0;
				continue;
			}
			if (j == needle.length())
				return i_begin;
		}
		return -1;
	}

	public int strStr2(String haystack, String needle) {
		if (haystack == null || needle == null)
			return -1;
		if (needle.length() == 0)
			return 0;
		for (int i = 0; i < haystack.length(); i++) {
			for (int j = 0; j < needle.length() && i + j < haystack.length(); j++) {
				cnt++;
				if (haystack.charAt(i + j) != needle.charAt(j))
					break;
				else if (j + 1 == needle.length())
					return i;
			}
		}
		return -1;
	}
}
