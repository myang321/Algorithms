public class Searcha2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = { { 1 } };
		searchMatrix(a, 1);
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		for (int i = matrix.length - 1; i >= 0; i--) {
			if (matrix[i][0] <= target) {
				for (int j = 0; j < matrix[i].length; j++) {
					if (matrix[i][j] == target)
						return true;
				}
				return false;
			}
		}
		return false;
	}
}
