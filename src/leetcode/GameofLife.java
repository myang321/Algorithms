package leetcode;

public class GameofLife {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameofLife g = new GameofLife();
		int[][] board = { { 1, 1 }, { 1, 0 } };
		g.gameOfLife(board);

	}

	public void gameOfLife(int[][] board) {
		int n = board.length;
		int m = board[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int cnt = 0;
				for (int i2 = Math.max(0, i - 1); i2 < Math.min(i + 2, n); i2++)
					for (int j2 = Math.max(0, j - 1); j2 < Math.min(j + 2, m); j2++) {
						if (i2 == i && j2 == j)
							continue;
						cnt += board[i2][j2] % 2;
					}
				// use second bit to represent next status
				if (cnt == 3 || (cnt == 2 && board[i][j] == 1))
					board[i][j] += 2;
			}
		}
		// remove lower bit
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				board[i][j] >>= 1;
	}
}
