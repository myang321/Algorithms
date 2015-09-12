package leetcode;
import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LetterCombinationsofaPhoneNumber l = new LetterCombinationsofaPhoneNumber();
		l.letterCombinations("7");
	}

	List<String> arr;
	String digits;

	public List<String> letterCombinations(String digits) {
		arr = new ArrayList<String>();
		this.digits = digits;
		dfs(0, new StringBuffer(""));
		return arr;
	}

	public void dfs(int dep, StringBuffer sb) {
		if (dep == digits.length()) {
			arr.add(sb.toString());
			return;
		}
		char c = '0';
		int n = 0;
		int num = digits.charAt(dep) - '0';
		if (num < 7) {
			n = 3;
			c = (char) ('a' + ((num - 2) * 3));
		} else if (num == 7) {
			n = 4;
			c = 'p';
		} else if (num == 8) {
			n = 3;
			c = 't';
		} else if (num == 9) {
			n = 4;
			c = 'w';
		}
		for (int i = 0; i < n; i++) {
			dfs(dep + 1, new StringBuffer(sb).append((char) (c + i)));
		}
	}
}
