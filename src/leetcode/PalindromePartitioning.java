package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-gnerated method stub
		PalindromePartitioning pp = new PalindromePartitioning();
		System.out.println(pp.partition("efe"));
		// String str = "abc";
		// System.out.println(str.substring(0, 1));
		// System.out.println(str.substring(1));

	}

	// max result 2^(n-1), so result is exponential 
	private ArrayList<List<String>> results;

	public List<List<String>> partition(String s) {
		results = new ArrayList<List<String>>();
		dfs(s, new ArrayList<String>());
		return results;

	}

	private void dfs(String remainStr, ArrayList<String> result) {
		if (remainStr.isEmpty()) {
			results.add(result);
			return;
		}
		int len = remainStr.length();
		for (int i = 1; i <= len; i++) {
			String subStr = remainStr.substring(0, i);
			String newRemainStr = remainStr.substring(i);
			if (isPalindrome(subStr)) {
				ArrayList<String> newResult = new ArrayList<String>(result);
				newResult.add(subStr);
				dfs(newRemainStr, newResult);
			}
		}
	}

	private boolean isPalindrome(String s) {
		int len = s.length();
		for (int i = 0; i < len / 2; i++) {
			if (s.charAt(i) != s.charAt(len - i - 1))
				return false;
		}
		return true;
	}

}
