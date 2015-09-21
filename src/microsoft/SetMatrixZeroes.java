package microsoft;

public class SetMatrixZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private void clearRow(int[][] matrix, int row) {
		for (int i = 0; i < matrix[0].length; i++)
			matrix[row][i] = 0;
	}

	private void clearCol(int[][] matrix, int col) {
		for (int i = 0; i < matrix.length; i++)
			matrix[i][col] = 0;
	}

	public void setZeroes(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;
		boolean zeroInFirstRow = false;
		boolean zeroInFirstCol = false;
		int n = matrix.length;
		int m = matrix[0].length;
		for (int i = 0; i < n; i++) {
			if (matrix[i][0] == 0) {
				zeroInFirstCol = true;
				break;
			}
		}
		for (int i = 0; i < m; i++) {
			if (matrix[0][i] == 0) {
				zeroInFirstRow = true;
				break;
			}
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for (int i = 1; i < n; i++) {
			if (matrix[i][0] == 0)
				clearRow(matrix, i);
		}
		for (int i = 1; i < m; i++) {
			if (matrix[0][i] == 0)
				clearCol(matrix, i);
		}
		if (zeroInFirstCol)
			clearCol(matrix, 0);
		if (zeroInFirstRow)
			clearRow(matrix, 0);
	}
}
