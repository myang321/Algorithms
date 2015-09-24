package leetcode;

public class BitwiseANDofNumbersRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BitwiseANDofNumbersRange b = new BitwiseANDofNumbersRange();
		System.out.println(b.rangeBitwiseAnd(3, 0));

	}

	// 1&0=0, a position will be 0 if there are more than one number
	public int rangeBitwiseAnd(int m, int n) {
		// 1 is 2^0, means 0 zero
		int f = 1;
		while (m != n) {
			m >>= 1;
			n >>= 1;
			f <<= 1;
		}
		// f is the number of zeros following the remaining of m
		// when m==n, m&n=m
		return m * f;
	}
}
