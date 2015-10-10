package leetcode;

import java.util.HashMap;

public class WordPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean wordPattern(String pattern, String str) {
		HashMap<Character, String> hm = new HashMap<Character, String>();
		HashMap<String, Character> hm2 = new HashMap<String, Character>();
		String[] array = str.split(" ");
		int len = pattern.length();

		// map char->string
		int i = 0;
		for (String s : array) {
			if (i >= len)
				return false;
			if (s.isEmpty())
				continue;
			char c = pattern.charAt(i);
			if (hm.containsKey(c)) {
				if (hm.get(c).equals(s) == false)
					return false;
			} else {
				hm.put(c, s);
			}
			i++;

		}
		if (i != len)
			return false;

		// map String->char
		i = 0;
		for (char c : pattern.toCharArray()) {
			while (array[i].isEmpty())
				i++;
			if (hm2.containsKey(array[i])) {
				if (hm2.get(array[i]) != c)
					return false;
			} else {
				hm2.put(array[i], c);
			}
			i++;
		}
		return true;
	}
}
