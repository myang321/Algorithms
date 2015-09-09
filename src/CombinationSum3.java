import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSum3 cs3 = new CombinationSum3();
		System.out.println(cs3.combinationSum3(3, 9));

	}

	private List<List<Integer>> results;

	public List<List<Integer>> combinationSum3(int k, int n) {
		results = new ArrayList<List<Integer>>();
		dfs(k, new ArrayList<Integer>(), 1, n);
		return results;
	}

	private void dfs(int depRemain, ArrayList<Integer> result, int i,
			int sumRemain) {
		if (sumRemain < 0)
			return;
		if (depRemain == 0) {
			if (sumRemain != 0)
				return;
			results.add(result);
			return;
		}
		for (; i <= 9; i++) {
			ArrayList<Integer> newResult = new ArrayList<Integer>(result);
			newResult.add(i);
			// System.out.println(newResult);
			// System.out.println(sumRemain);
			dfs(depRemain - 1, newResult, i + 1, sumRemain - i);
		}
	}
}
