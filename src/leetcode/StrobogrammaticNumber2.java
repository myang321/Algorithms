package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrobogrammaticNumber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// A strobogrammatic number is a number that looks the same when rotated 180
	// degrees (looked at upside down).
	//
	// Find all strobogrammatic numbers that are of length = n.
	//
	// For example,
	// Given n = 2, return ["11","69","88","96"].
	//
	// Hint:
	//
	// Try to use recursion and notice that it should recurse with n - 2 instead
	// of n - 1.
	public List<String> findStrobogrammatic(int n) {
		List<String> list = new ArrayList<String>();
		char[][] stro = { { '9', '6' }, { '6', '9' }, { '1', '1' },
				{ '8', '8' } };
		// odd start from 1, even start from 0
		if (n % 2 == 1)
			list.addAll(Arrays.asList(new String[] { "0", "1", "8" }));
		else
			list.add("");
		int cnt = n / 2;
		while (cnt-- > 0) {
			List<String> list2 = new ArrayList<String>();
			for (String s : list) {
				for (int i = 0; i < stro.length; i++) {
					StringBuffer sb = new StringBuffer(s);
					sb.insert(0, stro[i][0]);
					sb.append(stro[i][1]);
					list2.add(sb.toString());
				}
				if (cnt != 0)
					list2.add('0' + s + '0');
				list = list2;
			}
		}
		return list;
	}

	public List<String> findStrobogrammatic2(int n) {
		List<String> list = new ArrayList<String>();
		// odd start from 1, even start from 0
		if (n % 2 == 1)
			list.addAll(Arrays.asList(new String[] { "0", "1", "8" }));
		else
			list.add("");
		int cnt = n / 2;
		while (cnt-- > 0) {
			List<String> list2 = new ArrayList<String>();
			for (String s : list) {
				list2.add('9' + s + '6');
				list2.add('6' + s + '9');
				list2.add('1' + s + '1');
				list2.add('8' + s + '8');
				if (cnt != 0)
					list2.add('0' + s + '0');
				list = list2;
			}
		}
		return list;
	}
}
