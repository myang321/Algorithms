public class RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;
		int len = matrix.length;
		int tmp;
		for (int i = 0; i < len / 2; i++) {
			for (int j = 0; j < len; j++) {
				tmp = matrix[i][j];
				matrix[i][j] = matrix[len - 1 - i][j];
				matrix[len - 1 - i][j] = tmp;
			}
		}
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
	}
}
