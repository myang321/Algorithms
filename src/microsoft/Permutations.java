package microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutations p = new Permutations();
		int[] nums = { 1, 2, 3 };
		System.out.println(p.permute(nums));

	}

	private List<List<Integer>> results;
	private int[] nums;
	private boolean[] mark;

	public List<List<Integer>> permute(int[] nums) {
		results = new ArrayList<List<Integer>>();
		this.nums = nums;
		mark = new boolean[nums.length];
		Arrays.fill(mark, false);
		dfs(nums.length, new ArrayList<Integer>());
		return results;
	}

	private void dfs(int dep, List<Integer> result) {
		if (dep == 0) {
			results.add(result);
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (mark[i] == false) {
				List<Integer> newResult = new ArrayList<Integer>(result);
				newResult.add(nums[i]);
				mark[i] = true;
				dfs(dep - 1, newResult);
				mark[i] = false;
			}
		}
	}
}
