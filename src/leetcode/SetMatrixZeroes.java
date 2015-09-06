public class SetMatrixZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void setZeroes(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;
		int row = matrix.length;
		int col = matrix[0].length;
		boolean c0 = false;
		boolean r0 = false;
		for (int i = 0; i < row; i++) {
			if (matrix[i][0] == 0) {
				r0 = true;
				break;
			}
		}

		for (int i = 0; i < col; i++) {
			if (matrix[0][i] == 0) {
				c0 = true;
				break;
			}
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++)
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (matrix[0][j] == 0 || matrix[i][0] == 0)
					matrix[i][j] = 0;
			}
		}
		if (c0) {
			for (int i = 0; i < col; i++)
				matrix[0][i] = 0;
		}

		if (r0) {
			for (int i = 0; i < row; i++)
				matrix[i][0] = 0;
		}
	}
}
