package leetcode;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "fohhemkkaecojceoaejkkoedkofhmohkcjmkggcmnami";
		String[] arr = { "fohhemkka", "ecojceoaejkkoed", "kofhmoh",
				"kcjmkggcmnami" };
		// System.out.println(s.substring(1, 2));
		WordBreak w = new WordBreak();
		HashSet<String> dict = new HashSet<String>();
		for (String e : arr)
			dict.add(e);
		System.out.println(w.wordBreak(s, dict));
		System.out.println("abc".substring(0, 3));
	}

	public boolean wordBreak(String s, Set<String> wordDict) {
		if (s == null || s.length() == 0)
			return false;
		int max = maxLen(wordDict);
		int min = minLen(wordDict);
		int len = s.length();
		// f[i] means s.substring(0,i+1) can be segmented
		boolean[] f = new boolean[len];
		// System.out.println(min + " " + max);
		// f[0] = true;
		for (int i = 0; i < len; i++) {
			f[i] = false;
			for (int j = min; j <= max && j <= i + 1; j++) {
				if (i - j >= 0 && !f[i - j])
					continue;
				String tmp = s.substring(i + 1 - j, i + 1);
				if (wordDict.contains(tmp)) {
					f[i] = true;
					break;
				}
			}
		}
		// for (int i = 0; i < len; i++)
		// System.out.println(i + " " + f[i]);
		return f[len - 1];
	}

	private int maxLen(Set<String> dict) {
		int max = -1;
		for (String s : dict) {
			max = Math.max(max, s.length());
		}
		return max;
	}

	private int minLen(Set<String> dict) {
		int min = Integer.MAX_VALUE;
		for (String s : dict) {
			min = Math.min(min, s.length());
		}
		return min;
	}
}
