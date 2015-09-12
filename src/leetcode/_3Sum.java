package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_3Sum s = new _3Sum();
		int[] num = { 0, 0, 0, 0 };
		s.threeSum(num);
	}

	public ArrayList<List<Integer>> threeSum(int[] num) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			if (i>0 && num[i]==num[i-1])
				continue;
			int j = i + 1;
			int k = num.length - 1;
			while (j < k) {
				int sum = num[i] + num[j] + num[k];
				if (sum == 0) {
					result.add(Arrays.asList(num[i], num[j], num[k]));
					j++;
					while (j < k && num[j] == num[j - 1])
						j++;

				} else if (sum > 0) {
					k--;
					while (j < k && num[k] == num[k + 1])
						k--;
				} else {
					j++;
					while (j < k && num[j] == num[j - 1])
						j++;
				}
			}
		}
		return result;
	}
}
