package leetcode;
import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSum c = new CombinationSum();
		int[] arr = { 1 };
		c.combinationSum(arr, 1);

	}

	private ArrayList<ArrayList<Integer>> result;
	private int[] candidates;

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {
		Arrays.sort(candidates);
		this.candidates = candidates;
		result = new ArrayList<ArrayList<Integer>>();
		helper(target, new ArrayList<Integer>(), 0);
		return result;
	}

	private void helper(int current_target, ArrayList<Integer> array, int idx) {
		if (current_target == 0)
			result.add(new ArrayList<Integer>(array));
		for (int i = idx; i < this.candidates.length; i++) {
			if (current_target - candidates[i] < 0)
				return;
			ArrayList<Integer> array2 = new ArrayList<Integer>(array);
			array2.add(candidates[i]);
			helper(current_target - candidates[i], array2, i);
		}
	}
}
