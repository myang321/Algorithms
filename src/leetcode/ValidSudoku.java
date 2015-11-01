package leetcode;

public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isValidSudoku(char[][] board) {

		char[] tmp = new char[9];
		for (int i = 0; i < 9; i++) {
			if (is1to9(board[i]) == false)
				return false;
			for (int j = 0; j < 9; j++) {
				tmp[j] = board[j][i];
			}
			if (is1to9(tmp) == false)
				return false;

		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int ii = 0; ii < 3; ii++) {
					for (int jj = 0; jj < 3; jj++) {
						tmp[ii * 3 + jj] = board[3 * i + ii][j * 3 + jj];
					}
				}
				if (is1to9(tmp) == false)
					return false;
			}
		}
		return true;
	}

	public static boolean is1to9(char[] arr) {
		boolean[] tmp = new boolean[9];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '.')
				continue;
			int idx = arr[i] - '1';
			if (tmp[idx] == true)
				return false;
			else
				tmp[idx] = true;
		}
		return true;
	}

}
