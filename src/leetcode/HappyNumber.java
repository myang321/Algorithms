package leetcode;
import java.util.HashSet;

public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isHappy(int n) {
		HashSet<Integer> hs = new HashSet<Integer>();
		while (n != 1) {
			int sum = 0;
			int n2 = n;
			while (n2 > 0) {
				int r = n2 % 10;
				n2 /= 10;
				sum += r * r;
			}
			n = sum;
			if (hs.contains(sum))
				break;
			hs.add(sum);
		}
		if (n == 1)
			return true;
		else
			return false;
	}

}
