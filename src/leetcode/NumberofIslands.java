package leetcode;

import java.util.LinkedList;

public class NumberofIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private int n;
	private int m;

	// find all connected component, using bfs
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int cnt = 0;
		n = grid.length;
		m = grid[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == '1') {
					cnt++;
					bfs(grid, i, j);
				}
			}
		}
		return cnt;
	}

	private void bfs(char[][] grid, int x, int y) {
		LinkedList<Integer> xList = new LinkedList<Integer>();
		LinkedList<Integer> yList = new LinkedList<Integer>();
		xList.add(x);
		yList.add(y);
		// right, down, left, up
		int[][] move = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		while (!xList.isEmpty()) {
			x = xList.pop();
			y = yList.pop();
			for (int i = 0; i < 4; i++) {
				int x1 = x + move[i][0];
				int y1 = y + move[i][1];
				if (x1 >= 0 && y1 >= 0 && x1 < n && y1 < m
						&& grid[x1][y1] == '1') {
					xList.add(x1);
					yList.add(y1);
					// mark visited cell
					grid[x1][y1] = '2';
				}
			}
		}
	}
}
