package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueWordAbbreviation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidWordAbbr u = new ValidWordAbbr(new String[] { "hello" });
		System.out.println(u.isUnique("hello"));
	}
	// An abbreviation of a word follows the form <first letter><number><last
	// letter>. Below are some examples of word abbreviations:
	//
	// a) it --> it (no abbreviation)
	//
	// 1
	// b) d|o|g --> d1g
	//
	// 1 1 1
	// 1---5----0----5--8
	// c) i|nternationalizatio|n --> i18n
	//
	// 1
	// 1---5----0
	// d) l|ocalizatio|n --> l10n
	// Assume you have a dictionary and given a word, find whether its
	// abbreviation is unique in the dictionary. A word's abbreviation is unique
	// if no other word from the dictionary has the same abbreviation.
	//
	// Example:
	//
	// Given dictionary = [ "deer", "door", "cake", "card" ]
	//
	// isUnique("dear") -> false
	// isUnique("cart") -> true
	// isUnique("cane") -> false
	// isUnique("make") -> true */

}

class ValidWordAbbr {
	// <abbr, key count>
	private HashMap<String, Integer> hmCnt;
	// <original word>
	private HashSet<String> hs;

	public ValidWordAbbr(String[] dictionary) {
		hmCnt = new HashMap<String, Integer>();
		hs = new HashSet<String>();
		for (String s : dictionary) {
			String key = abbr(s);
			if (hs.contains(key)) {
				// skip duplicate word
				continue;
			} else if (hmCnt.containsKey(key)) {
				hs.add(s);
				hmCnt.put(key, hmCnt.get(key) + 1);
			} else {
				hs.add(s);
				hmCnt.put(key, 1);
			}
		}
	}

	// unique if word not in dic, and key count=0
	// or word in dic, and key count =1
	public boolean isUnique(String word) {
		String key = abbr(word);
		if (hs.contains(word)) {
			System.out.println(hmCnt.get(key));
			return hmCnt.get(key) == 1;
		} else if (hmCnt.containsKey(key)) {
			return false;
		}
		return true;
	}

	private String abbr(String s) {
		int len = s.length();
		if (len < 3)
			return s;
		return "" + s.charAt(0) + (len - 2) + s.charAt(len - 1);
	}
}
