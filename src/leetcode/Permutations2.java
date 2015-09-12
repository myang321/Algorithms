package leetcode;
import java.util.ArrayList;
import java.util.Arrays;

public class Permutations2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutations2 p = new Permutations2();
		int[] num = { -1, -1, 3 };
		System.out.println(p.permuteUnique(num));
	}

	private ArrayList<ArrayList<Integer>> result;
	private int len;
	private boolean[] visited;
	private int[] num;
	private int[] current;

	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		Arrays.sort(num);
		result = new ArrayList<ArrayList<Integer>>();
		this.len = num.length;
		visited = new boolean[len];
		current = new int[len];
		Arrays.fill(visited, false);
		this.num = num;
		dfs(0);
		return result;
	}

	private void dfs(int dep) {
		if (dep == this.len) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			for (int e : current)
				tmp.add(e);
			result.add(tmp);
		}
		for (int i = 0; i < len; i++) {
			if (visited[i])
				continue;
			if (i > 0 && num[i] == num[i - 1] && !visited[i - 1])
				continue;
			visited[i] = true;
			current[dep] = num[i];
			dfs(dep + 1);
			visited[i] = false;
		}
	}
}
