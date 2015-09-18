package leetcode;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStrings {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		// java.util.Date date = new java.util.Date();
		// System.out.println(date);
		// System.out.println(new Timestamp(date.getTime()));

		// String s = "2015-08-11 16:56:45";
		// DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// Date date2 = format.parse(s);
		// System.out.println(date2);

		HashSet<String> hs = new HashSet<String>();
		hs.add(new String("abc"));
		hs.add(new String("abc"));
		System.out.println("hash set size:" + hs.size());
	}

	public static boolean isIsomorphic2(String s, String t) {
		if (s == null || s.length() == 0)
			return true;
		HashMap<Character, Integer> hms = new HashMap<Character, Integer>();
		HashMap<Character, Integer> hmt = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char cs = s.charAt(i);
			char ct = t.charAt(i);
			if (!hms.containsKey(cs)) {
				// i is the first position of cs
				hms.put(cs, i);
			}
			if (!hmt.containsKey(ct)) {
				hmt.put(ct, i);
			}
			// the first position of cs and ct should be the same
			if (hms.get(cs) != hmt.get(ct))
				return false;
		}
		return true;
	}

	public static boolean isIsomorphic(String s, String t) {
		if (s == null || s.length() == 0)
			return true;
		int[] sArray = new int[256];
		int[] tArray = new int[256];
		for (int i = 0; i < s.length(); i++) {
			int idxs = s.charAt(i);
			int idxt = t.charAt(i);
			// last position of idxs and idxt should be the same
			if (sArray[idxs] != tArray[idxt])
				return false;
			// value start from 1 not 0
			sArray[idxs] = i + 1;
			tArray[idxt] = i + 1;
		}
		return true;
	}
}
