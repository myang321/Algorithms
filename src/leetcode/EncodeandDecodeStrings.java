package leetcode;

import java.util.ArrayList;
import java.util.List;

public class EncodeandDecodeStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// StringBuffer sb = new StringBuffer("ab");
		// sb.insert(0, '*');
		// System.out.println(sb);
		Codec c = new Codec();
		List<String> strs = new ArrayList<String>();
		strs.add("abc");
		strs.add("edf");
		strs.add("***");
		String s = c.encode(strs);
		System.out.println(s);
		List<String> strs2 = c.decode(s);
		System.out.println(strs2);
	}
}

class Codec {

	// Encodes a list of strings to a single string.
	public String encode(List<String> strs) {
		StringBuffer result = new StringBuffer();
		for (String s : strs) {
			StringBuffer sb = new StringBuffer(s);
			int len = s.length();
			int cnt = 0;
			int idx = 0;
			while (cnt++ < len) {
				if (sb.charAt(idx) == '*') {
					sb.insert(idx, '*');
					idx++;
				}
				idx++;
			}
			result.append(sb);
			result.append("*n");
		}
		return result.toString();
	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {
		ArrayList<String> result = new ArrayList<String>();
		int idx = 0;
		while (idx < s.length()) {
			StringBuffer sb = new StringBuffer();
			boolean star = false;
			while (idx < s.length()) {
				char c = s.charAt(idx);
				if (star) {
					if (c == 'n')
						break;
					else {
						sb.append(c);
						star = false;
					}
				} else {
					if (c == '*')
						star = true;
					else
						sb.append(c);
				}
				idx++;
			}
			idx++;
			result.add(sb.toString());
		}
		return result;
	}
}