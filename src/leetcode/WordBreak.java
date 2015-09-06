import java.util.HashSet;

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
	}

	public boolean wordBreak(String s, HashSet<String> dict) {
		if (s == null || s.length() == 0)
			return false;
		int max = maxLen(dict);
		int min = minLen(dict);
		int len = s.length();
		boolean[] f = new boolean[len];
		System.out.println(min + " " + max);
		// f[0] = true;
		for (int i = 0; i < len; i++) {
			f[i] = false;
			for (int j = min; j <= max && j <= i + 1; j++) {
				if (i - j >= 0 && !f[i - j])
					continue;
				String tmp = s.substring(i + 1 - j, i + 1);
				if (dict.contains(tmp)) {
					f[i] = true;
					break;
				}
			}
		}
		for (int i = 0; i < len; i++)
			System.out.println(i + " " + f[i]);
		return f[len - 1];
	}

	private int maxLen(HashSet<String> dict) {
		int max = -1;
		for (String s : dict) {
			max = Math.max(max, s.length());
		}
		return max;
	}

	private int minLen(HashSet<String> dict) {
		int min = Integer.MAX_VALUE;
		for (String s : dict) {
			min = Math.min(min, s.length());
		}
		return min;
	}
}
