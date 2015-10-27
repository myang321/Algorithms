package others;

public class RearrangeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RearrangeString r = new RearrangeString();
		String s = "aaaabb";
		System.out.println(r.f(s));

	}

	// rearrage string so that no wo same letter next to each other
	public String f(String s) {
		int len = s.length();
		int[] cnt = new int[26];
		for (char c : s.toCharArray())
			cnt[c - 'a']++;
		char[] result = new char[len];
		int even_idx = 0;
		int odd_idx = 1;
		while (true) {
			int max = 0;
			int max_idx = -1;
			for (int i = 0; i < 26; i++) {
				if (cnt[i] > max) {
					max = cnt[i];
					max_idx = i;
				}
			}
			if (max == 0)
				break;
			if (max > (1 + len) / 2)
				return "impossible";
			cnt[max_idx] = 0;
			char c = (char) ('a' + max_idx);
			while (max > 0 && even_idx < len) {
				result[even_idx] = c;
				max--;
				even_idx += 2;
			}
			while (max > 0 && odd_idx < len) {
				result[odd_idx] = c;
				max--;
				odd_idx += 2;
			}
		}
		return new String(result);
	}

}
