package leetcode;
import java.util.ArrayList;

public class N_Queens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N_Queens n = new N_Queens();
		n.solveNQueens(4);
	}

	private int n;
	private ArrayList<String[]> result;

	public ArrayList<String[]> solveNQueens(int n) {
		this.n = n;
		result = new ArrayList<String[]>();
		dfs(new ArrayList<Integer>());
		return result;
	}

	private void dfs(ArrayList<Integer> arr) {
		if (arr.size() == this.n) {
			draw(arr);
			return;
		}
		for (int i = 0; i < this.n; i++) {
			if (isValid(arr, i)) {
				arr.add(i);
				dfs(arr);
				arr.remove(arr.size() - 1);
			}
		}
	}

	private void draw(ArrayList<Integer> arr) {
		String[] strs = new String[this.n];
		char[] cs = new char[this.n];
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.n; j++) {
				cs[j] = j == arr.get(i) ? 'Q' : '.';
			}
			strs[i] = new String(cs);
		}
		result.add(strs);
	}

	private boolean isValid(ArrayList<Integer> arr, int num) {
		int row = arr.size();
		for (int i = 0; i < row; i++) {
			int curr = arr.get(i);
			if (curr == num)
				return false;
			if (curr - num == i - row)
				return false;
			if (curr + i == num + row)
				return false;
		}
		return true;
	}

}
