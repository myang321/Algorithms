import java.util.Arrays;

public class RectangleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		int x1, y1, x2, y2;
		int xArray[] = sortFour(A, C, E, G);
		int yArray[] = sortFour(B, D, F, H);
		x1 = xArray[0];
		x2 = xArray[1];
		y1 = yArray[0];
		y2 = yArray[1];
		int result = calArea(A, B, C, D) + calArea(E, F, G, H);
		// check x axis
		if (isBetween(E, G, A) || isBetween(E, G, C) || isBetween(A, C, E)
				|| isBetween(A, C, G))
			// check y axis
			if (isBetween(F, H, B) || isBetween(F, H, D) || isBetween(B, D, F)
					|| isBetween(B, D, H))
				result -= calArea(x1, y1, x2, y2);
		return result;
	}

	public int calArea(int x1, int y1, int x2, int y2) {
		return Math.abs((x2 - x1) * (y2 - y1));
	}
	// return middle 2 num of the 4 num
	public int[] sortFour(int a, int b, int c, int d) {
		int array[] = { a, b, c, d };
		Arrays.sort(array);
		int result[] = new int[2];
		result[0] = array[1];
		result[1] = array[2];
		return result;
	}

	public boolean isBetween(int a, int b, int x) {
		if (b < a) {
			int c = b;
			b = a;
			a = c;
		}
		if (a <= x && x <= b)
			return true;
		return false;
	}

}
