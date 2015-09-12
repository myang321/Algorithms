package leetcode;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 3, 2, 4 };

		twoSum(a, 6);
	}

	public static int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		int[] res = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			h.put(numbers[i], i + 1);
		}
		for (int i = 0; i < numbers.length; i++) {
			if (h.containsKey(target - numbers[i])) {
				res[0] = i + 1;
				res[1] = h.get(target - numbers[i]);
				if (res[0] == res[1])
					continue;
				else
					break;
			}
		}
		return res;
	}

	public static int[] twoSum2(int[] numbers, int target) {
		int[] numbers2 = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++)
			numbers2[i] = numbers[i];
		Arrays.sort(numbers);
		int[] res = new int[2];
		int left = 0;
		int lValue = 0;
		int right = numbers.length - 1;
		int rValue = 0;
		while (left < right) {
			int sum = numbers[left] + numbers[right];
			if (sum == target) {
				lValue = numbers[left];
				rValue = numbers[right];
				break;
			} else if (sum < target) {
				left++;
			} else
				right--;
		}
		boolean flag = false;
		for (int i = 0; i < numbers.length; i++) {
			if (!flag && numbers2[i] == lValue) {
				res[0] = i + 1;
				flag = true;
			}
			if (numbers2[i] == rValue) {
				res[1] = i + 1;
			}
		}
		if (res[0] > res[1]) {
			int tmp = res[0];
			res[0] = res[1];
			res[1] = tmp;
		}
		return res;
	}
}
