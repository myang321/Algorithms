package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DifferentWaystoAddParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// for each sign, split the string into two, and do recursion
	public List<Integer> diffWaysToCompute2(String input) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch == '+' || ch == '-' || ch == '*') {
				// 0 to i-1
				String left = input.substring(0, i);
				// i+1 to end
				String right = input.substring(i + 1);
				List<Integer> arr1 = diffWaysToCompute(left);
				List<Integer> arr2 = diffWaysToCompute(right);
				int val = 0;
				for (Integer i1 : arr1) {
					for (Integer i2 : arr2) {
						if (ch == '+')
							val = i1 + i2;
						else if (ch == '-')
							val = i1 - i2;
						else if (ch == '*')
							val = i1 * i2;
						result.add(val);
					}
				}
			}
		}
		// input is single number, end of recursion
		if (result.size() == 0)
			result.add(Integer.parseInt(input));
		return result;
	}

	private HashMap<String, ArrayList<Integer>> hm = new HashMap<String, ArrayList<Integer>>();

	// for each sign, split the string into two, and do recursion
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch == '+' || ch == '-' || ch == '*') {
				// 0 to i-1
				String left = input.substring(0, i);
				// i+1 to end
				String right = input.substring(i + 1);
				List<Integer> arr1 = null;
				List<Integer> arr2 = null;
				// memorization
				if (hm.containsKey(left))
					arr1 = hm.get(left);
				else
					arr1 = diffWaysToCompute(left);
				if (hm.containsKey(right))
					arr2 = hm.get(right);
				else
					arr2 = diffWaysToCompute(right);
				int val = 0;
				for (Integer i1 : arr1) {
					for (Integer i2 : arr2) {
						if (ch == '+')
							val = i1 + i2;
						else if (ch == '-')
							val = i1 - i2;
						else if (ch == '*')
							val = i1 * i2;
						result.add(val);
					}
				}
			}
		}
		// input is single number, end of recursion
		if (result.size() == 0)
			result.add(Integer.parseInt(input));
		return result;
	}

}
