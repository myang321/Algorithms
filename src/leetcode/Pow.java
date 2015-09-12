package leetcode;
public class Pow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pow p = new Pow();
		p.pow(34.00515, -3);
	}

	public double pow(double x, int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return x;
		boolean isNega = false;
		if (n < 0) {
			n = -n;
			isNega = true;
		}
		int k = n / 2;
		double res1 = pow(x, k);
		double res2 = pow(x, n - k * 2);
		double res = res1 * res1 * res2;
		if (isNega)
			return 1 / res;
		else
			return res;
	}
}
