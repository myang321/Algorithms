public class PowerofTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isPowerOfTwo(1);

	}

	public static boolean isPowerOfTwo(int n) {
		if (n <= 0)
			return false;
		return (n & (n - 1)) == 0;
	}

}
