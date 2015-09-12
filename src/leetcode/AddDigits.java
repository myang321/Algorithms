package leetcode;
public class AddDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int addDigits(int num) {
		if (num == 0)
			return 0;
		int result = num % 9;
		if (result == 0)
			result = 9;
		return result;
	}

}
