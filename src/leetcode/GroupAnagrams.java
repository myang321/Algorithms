package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GroupAnagrams g = new GroupAnagrams();
		String s = "";
		String[] strs = { s };
		System.out.println(g.groupAnagrams(strs));
	}

	// sort char array to find anagram
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, ArrayList<String>> m = new HashMap<String, ArrayList<String>>();
		List<List<String>> result = new ArrayList<List<String>>();
		for (String s : strs) {
			String key = sortStr(s);
			if (!m.containsKey(key)) {
				m.put(key, new ArrayList<String>());
			}
			m.get(key).add(s);
		}
		for (ArrayList<String> l : m.values()) {
			Collections.sort(l);
			result.add(l);
		}
		return result;
	}

	private String sortStr(String s) {
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}

	// ///////////////////////////////////////////////////////////////////
	public ArrayList<String> anagrams2(String[] strs) {

		HashMap<Integer, ArrayList<String>> m = new HashMap<Integer, ArrayList<String>>();
		ArrayList<String> result = new ArrayList<String>();
		for (String s : strs) {
			int num = hash(s);
			if (!m.containsKey(num)) {
				m.put(num, new ArrayList<String>());
			}
			if (m.get(num).size() == 0 || isAna(m.get(num).get(0), s))
				m.get(num).add(s);
		}
		for (ArrayList<String> l : m.values()) {
			if (l.size() > 1) {
				result.addAll(l);
			}
		}
		return result;
	}

	private int hash(String s) {
		int[] arr = new int[26];
		for (char c : s.toCharArray()) {
			arr[c - 'a']++;
		}
		int a = 37;
		int b = 13;
		int m = 1000000;
		int sum = 0;
		for (int i = 0; i < 26; i++) {
			sum = sum * a + ((i + 1) * arr[i]) + b;
			sum %= m;
		}
		return sum;
	}

	private boolean isAna(String s1, String s2) {
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		for (int i = 0; i < s1.length(); i++) {
			if (arr1[i] != arr2[i])
				return false;
		}
		return true;
	}
}
