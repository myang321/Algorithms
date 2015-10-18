package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class SurroundedRegions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SurroundedRegions s = new SurroundedRegions();
		String[] strs = { "OO", "OO" };
		char[][] board = new char[strs.length][];
		for (int i = 0; i < strs.length; i++)
			board[i] = strs[i].toCharArray();
		s.solve(board);
		for (int i = 0; i < strs.length; i++)
			System.out.println(Arrays.toString(board[i]));
	}

	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	// 0: not visited
	// 1: first visiting
	// 2: after flip
	char[][] board;
	int n, m;
	int[][] move = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public void solve(char[][] board) {
		if (board == null || board.length == 0)
			return;
		this.board = board;
		n = board.length;
		m = board[0].length;
		for (int i = 0; i < n; i++) {
			if (board[i][0] == 'O')
				bfs(i, 0);
			if (board[i][m - 1] == 'O')
				bfs(i, m - 1);
		}
		for (int j = 0; j < m; j++) {
			if (board[0][j] == 'O')
				bfs(0, j);
			if (board[n - 1][j] == 'O')
				bfs(n - 1, j);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 'B')
					board[i][j] = 'O';
				else if (board[i][j] == 'O')
					board[i][j] = 'X';
			}
		}
	}

	private void bfs(int x, int y) {
		LinkedList<Point> queue = new LinkedList<Point>();
		queue.add(new Point(x, y));
		board[x][y] = 'B';
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + move[i][0];
				int ny = cur.y + move[i][1];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m
						&& board[nx][ny] == 'O') {
					// mark it before push not after poll !!!
					board[nx][ny] = 'B';
					queue.add(new Point(nx, ny));
				}

			}
		}
	}
}
