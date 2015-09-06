public class LongestCommonPrefix {

	public static void main(String[] args) {

	}

	public String longestCommonPrefix(String[] strs) {
		String s = "";
		if (strs.length == 0)
			return s;
		int idx = 0;
		while (true) {
			for (int i = 0; i < strs.length; i++) {
				if (idx >= strs[i].length())
					return s;
				if (strs[i].charAt(idx) != strs[0].charAt(idx))
					return s;
			}
			if (idx >= strs[0].length())
				return s;
			s += strs[0].charAt(idx);
			idx++;
		}
	}

}
