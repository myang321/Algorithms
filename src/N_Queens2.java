import java.util.ArrayList;

public class N_Queens2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private int n;
	private int result;

	public int totalNQueens(int n) {
		this.n = n;
		result = 0;
		dfs(new ArrayList<Integer>());
		return result;
	}

	private void dfs(ArrayList<Integer> arr) {
		if (arr.size() == this.n) {
			result++;
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
