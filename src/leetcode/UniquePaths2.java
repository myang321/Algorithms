package leetcode;
public class UniquePaths2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[][] = { { 0, 1, 0, 0, 0 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		uniquePathsWithObstacles(a);
	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int n = obstacleGrid.length;
		int m = obstacleGrid[0].length;
		int a[][] = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				obstacleGrid[i][j] ^= 1;
		a[0][0] = obstacleGrid[0][0];
		for (int i = 1; i < n; i++) {
			a[i][0] = obstacleGrid[i][0] * a[i - 1][0];
		}
		for (int i = 1; i < m; i++) {
			a[0][i] = obstacleGrid[0][i] * a[0][i - 1];
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				a[i][j] = obstacleGrid[i][j] * (a[i - 1][j] + a[i][j - 1]);
			}
		}
		return a[n - 1][m - 1];
	}
}
