public class ReverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseBits(Integer.MIN_VALUE));
	}

	public static int reverseBits(int n) {
		int m = 0;
		int cnt = 32;
		while (cnt > 0) {
			m <<= 1;
			if ((n & 1) == 1) {
				m += 1;
			}
			n >>>= 1;
			cnt--;
		}
		return m;
	}
}
