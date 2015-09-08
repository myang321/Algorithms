public class SpiralMatrix2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateMatrix(0);

	}

	public static int[][] generateMatrix(int n) {
		int[][] a = new int[n][n];
		if (n==0)
			return a;

		int i = 1;
		int r = 0;
		int c = 0;
		int tmpr = 0;
		int tmpc = 0;
		int dir = 0;// 0 right, 1 down, 2 left, 3 up
		while (true) {
			a[r][c] = i;
			if (i==n*n)
				break;
			if (dir == 0) {// right
				tmpr = r;
				tmpc = c + 1;
			} else if (dir == 1) {// down
				tmpr = r + 1;
				tmpc = c;
			} else if (dir == 2) {// left
				tmpr = r;
				tmpc = c - 1;
			} else if (dir == 3) {// up
				tmpr = r - 1;
				tmpc = c;
			}
			if (tmpr >= 0 && tmpr < n && tmpc >= 0 && tmpc < n
					&& a[tmpr][tmpc] == 0) {
				i++;
				r = tmpr;
				c = tmpc;
			} else
				dir = (dir + 1) % 4;
		}
		return a;
	}

}
