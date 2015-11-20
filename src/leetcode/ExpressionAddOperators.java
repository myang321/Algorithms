package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExpressionAddOperators e = new ExpressionAddOperators();
		System.out.println(e.addOperators("2147483648", -2147483648));
	}

	private List<String> result;
	private int target;
	private char[] num;

	public List<String> addOperators(String num, int target) {
		result = new ArrayList<String>();
		this.target = target;
		this.num = num.toCharArray();
		if (num == null || num.length() == 0)
			return result;
		dfs("", 0, 0, 0);
		return result;
	}

	private void dfs(String exp, int idx, long multed, long sum) {
		if (idx == num.length) {
			if (sum == target)
				result.add(exp);
			return;
		}
		long n = 0;
		for (int i = idx; i < num.length; i++) {
			n *= 10;
			n += num[i] - '0';
			if (i != idx && num[idx] == '0')
				return;
			if (idx == 0) {
				dfs(exp + n, i + 1, n, n);
			} else {
				dfs(exp + "+" + n, i + 1, n, sum + n);
				dfs(exp + "-" + n, i + 1, -n, sum - n);
				dfs(exp + "*" + n, i + 1, multed * n, sum - multed + multed * n);
			}
		}
	}
}
