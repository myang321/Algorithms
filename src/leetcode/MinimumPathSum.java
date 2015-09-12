package leetcode;
public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = { { 1, 2 }, { 1, 1 } };
		minPathSum(a);
	}

	public static int minPathSum(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[][] f = new int[n][m];
		f[0][0]=grid[0][0];
		for (int i = 1; i < n; i++)
			f[i][0] = grid[i][0] + f[i - 1][0];
		for (int i = 1; i < m; i++)
			f[0][i] = grid[0][i] + f[0][i - 1];
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
			}
		}
		return f[n - 1][m - 1];
	}
}
