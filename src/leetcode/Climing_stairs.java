package leetcode;
public class Climing_stairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int climbStairs(int n) {
		int f[] = new int[100];
		f[0] = 0;
		f[1] = 1;
		f[2] = 2;
		for (int i = 3; i <= n; i++) {
			f[i]=f[i-1]+f[i-2];
		}
		return f[n];
	}

}
