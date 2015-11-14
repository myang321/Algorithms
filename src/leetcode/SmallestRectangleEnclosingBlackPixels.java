package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SmallestRectangleEnclosingBlackPixels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmallestRectangleEnclosingBlackPixels s = new SmallestRectangleEnclosingBlackPixels();
		s.minArea(new char[][] { { '0', '0', '1', '0' },
				{ '0', '1', '1', '0' }, { '0', '1', '0', '0' } }, 0, 2);

	}

	public int minArea(char[][] image, int x, int y) {
		int move[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
		Queue<Point> q = new LinkedList<Point>();
		int n = image.length;
		int m = image[0].length;
		q.add(new Point(x, y));
		image[x][y] = '0';
		int minx = x;
		int miny = y;
		int maxx = x;
		int maxy = y;
		while (!q.isEmpty()) {
			Point p = q.poll();
			x = p.x;
			y = p.y;
			for (int i = 0; i < 4; i++) {
				int nx = x + move[i][0];
				int ny = y + move[i][1];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m
						&& image[nx][ny] == '1') {
					q.add(new Point(nx, ny));
					image[nx][ny] = '0';
					minx = Math.min(minx, nx);
					miny = Math.min(miny, ny);
					maxx = Math.max(maxx, nx);
					maxy = Math.max(maxy, ny);
				}
			}
		}
		return (maxx - minx + 1) * (maxy - miny + 1);
	}

	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
