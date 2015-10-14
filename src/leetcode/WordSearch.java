package leetcode;

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private char[][] board;
	private int n;
	private int m;
	private String word;

	public boolean exist(char[][] board, String word) {
		this.board = board;
		this.n = board.length;
		this.m = board[0].length;
		this.word = word;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (dfs(i, j, 0))
					return true;
		return false;
	}

	private boolean dfs(int i, int j, int idx) {
		if (idx == word.length())
			return true;
		if (i < 0 || i >= n || j < 0 || j >= m
				|| board[i][j] != word.charAt(idx))
			return false;
		// assume * not in board
		board[i][j] = '*';
		boolean found = dfs(i + 1, j, idx + 1) || dfs(i, j + 1, idx + 1)
				|| dfs(i - 1, j, idx + 1) || dfs(i, j - 1, idx + 1);
		// set char back to original
		board[i][j] = word.charAt(idx);
		return found;
	}
}
