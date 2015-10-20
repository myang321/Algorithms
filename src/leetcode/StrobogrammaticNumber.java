package leetcode;

public class StrobogrammaticNumber {

	public static void main(String[] args) {
		StrobogrammaticNumber s = new StrobogrammaticNumber();
		System.out.println(s.isStrobogrammatic("69169"));

	}

	// A strobogrammatic number is a number that looks the same when rotated 180
	// degrees (looked at upside down).
	//
	// Write a function to determine if a number is strobogrammatic. The number
	// is represented as a string.
	//
	// For example, the numbers "69", "88", and "818" are all strobogrammatic.

	public boolean isStrobogrammatic(String num) {
		int len = num.length();
		for (int i = 0; i < len / 2 + 1; i++) {
			int a = num.charAt(i) - '0';
			int b = num.charAt(len - i - 1) - '0';
			if (a == 8 && b == 8)
				continue;
			else if (a == 1 && b == 1)
				continue;
			else if (a == 9 && b == 6)
				continue;
			else if (a == 6 && b == 9)
				continue;
			else if (a == 0 && b == 0)
				continue;
			return false;
		}
		return true;
	}
}
