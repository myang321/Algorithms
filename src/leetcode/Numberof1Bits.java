package leetcode;
public class Numberof1Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(hammingWeight(-2147483648 ));
	}

	public static int hammingWeight(int n) {
		int cnt = 0;
		while (n != 0) {
			if ((n & 1) == 1)
				cnt++;
			n >>>= 1;
		}
		return cnt;
	}
	public static int hammingWeight2(int n) {
	    int count = 0;
	    for (; n != 0; n >>>= 1)
	        count += 1 & n;

	    return count;
	}
}
