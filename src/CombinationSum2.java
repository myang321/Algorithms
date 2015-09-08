import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSum2 c = new CombinationSum2();
		int[] num = { 10, 1, 2, 7, 6, 1, 5 };
		c.combinationSum2(num, 8);

	}

	public List<List<Integer>> combinationSum2_2(int[] num, int target) {
		if (num.length == 0)
			return new ArrayList<List<Integer>>();
		Arrays.sort(num);
		ArrayList<List<Integer>> result = helper(num, target, 0);
		if (result == null)
			result = new ArrayList<List<Integer>>();
		return result;

	}

	public ArrayList<List<Integer>> helper(int[] num, int target, int index) {
		if (index >= num.length || num[index] > target)
			return null;
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		Set<List<Integer>> s = new HashSet<List<Integer>>();
		for (int i = index; i < num.length; i++) {
			if (num[i] > target)
				break;
			tmp = new ArrayList<Integer>();
			if (num[i] == target) {
				tmp.add(num[i]);
				result.add(tmp);
				return result;
			}
			ArrayList<List<Integer>> t = helper(num, target - num[i], i + 1);
			if (t != null) {
				for (List<Integer> a : t) {
					a.add(0, num[i]);
					if (!s.contains(a)) {
						s.add(a);
						result.add(a);
					}
				}
			}

		}
		return result;
	}

	private ArrayList<ArrayList<Integer>> result;
	private int[] candidates;
	private HashSet<ArrayList<Integer>> hs;

	public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates,
			int target) {
		hs = new HashSet<ArrayList<Integer>>();
		Arrays.sort(candidates);
		this.candidates = candidates;
		result = new ArrayList<ArrayList<Integer>>();
		helper(target, new ArrayList<Integer>(), 0);
		return result;
	}

	private void helper(int current_target, ArrayList<Integer> array, int idx) {
		if (current_target == 0) {
			if (!hs.contains(array)) {
				ArrayList<Integer> arr = new ArrayList<Integer>(array);
				hs.add(arr);
				result.add(new ArrayList<Integer>(arr));
			}
		}
		for (int i = idx; i < this.candidates.length; i++) {
			if (current_target - candidates[i] < 0)
				return;
			ArrayList<Integer> array2 = new ArrayList<Integer>(array);
			array2.add(candidates[i]);
			helper(current_target - candidates[i], array2, i + 1);
		}
	}
}
