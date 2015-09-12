package leetcode;
import java.util.Arrays;

public class _3SumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int max_value = num[0] + num[1] + num[2];
		for (int i = 0; i < num.length - 2; i++) {
			int j = i + 1;
			int k = num.length - 1;
			while (j < k) {
				int sum = num[i] + num[j] + num[k];
				if (Math.abs(sum - target) < Math.abs(max_value - target))
					max_value = sum;
				if (sum - target < 0) {
					j++;
				} else {
					k--;
				}
			}
		}
		return max_value;
	}
}
