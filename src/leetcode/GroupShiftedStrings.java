package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GroupShiftedStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GroupShiftedStrings g = new GroupShiftedStrings();
		String[] strings = { "abc", "bcd", "acef", "xyz", "az", "ba", "z", "a" };
		List<List<String>> result = g.groupStrings(strings);
		System.out.println(result);

	}

	// Given a string, we can "shift" each of its letter to its successive
	// letter, for example: "abc" -> "bcd". We can keep "shifting" which forms
	// the sequence:
	// "abc" -> "bcd" -> ... -> "xyz"
	// Given a list of strings which contains only lowercase alphabets, group
	// all strings that belong to the same shifting sequence.
	// For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
	// Return:
	// [
	// ["abc","bcd","xyz"],
	// ["az","ba"],
	// ["acef"],
	// ["a","z"]
	// ]
	// Note: For the return value, each inner list's elements must follow the
	// lexicographic order.

	public List<List<String>> groupStrings(String[] strings) {
		List<List<String>> result = new ArrayList<List<String>>();
		HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
		for (String s : strings) {
			String key = getKey(s);
			ArrayList<String> value = null;
			if (hm.containsKey(key))
				value = hm.get(key);
			else
				value = new ArrayList<String>();
			value.add(s);
			hm.put(key, value);
		}
		for (String key : hm.keySet()) {
			ArrayList<String> value = hm.get(key);
			Collections.sort(value);
			result.add(value);
		}
		return result;
	}

	private String getKey(String s) {
		int len = s.length();
		char[] arr = new char[len];
		int shift = ('z' - s.charAt(0) + 1) % 26;
		for (int i = 0; i < len; i++) {
			char c2 = (char) ('a' + ((s.charAt(i) - 'a') + shift) % 26);
			arr[i] = c2;
		}
		return new String(arr);
	}

}
