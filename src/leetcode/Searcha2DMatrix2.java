package leetcode;

public class Searcha2DMatrix2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean searchMatrix(int[][] matrix, int target) {
		// start from top right corner
		// rule out one row or one column at a time
		int n = matrix.length;
		int m = matrix[0].length;
		int row = 0;
		int col = m - 1;
		while (row < n && col >= 0) {
			if (matrix[row][col] == target)
				return true;
			// rule out column, move left
			if (matrix[row][col] > target) {
				col--;
			}// rule out row, move down
			else {
				row++;
			}
		}
		return false;
	}
}
