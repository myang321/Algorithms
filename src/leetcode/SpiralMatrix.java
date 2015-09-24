package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiralMatrix sm = new SpiralMatrix();
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(sm.spiralOrder(matrix));
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0)
			return result;
		int[][] move = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int dir = 0;
		int n = matrix.length;
		int m = matrix[0].length;
		boolean visited[][] = new boolean[n][m];
		int k = m * n;
		int x = 0;
		int y = 0;
		while (true) {
			if (k == 0)
				break;
			if (x >= 0 && x < n && y >= 0 && y < m && visited[x][y] == false) {
				k--;
				visited[x][y] = true;
				result.add(matrix[x][y]);
			} else {
				x -= move[dir][0];
				y -= move[dir][1];
				dir = (dir + 1) % 4;
			}
			x += move[dir][0];
			y += move[dir][1];
		}
		return result;
	}
}
