package leetcode;
import java.util.Arrays;

public class FirstMissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int firstMissingPositive(int[] A) {
		boolean[] arr = new boolean[A.length];
		Arrays.fill(arr, false);
		for (int n : A) {
			if (n > 0 && n <= A.length)
				arr[n - 1] = true;
		}
		for (int i = 0; i < A.length; i++) {
			if (!arr[i])
				return i + 1;
		}
		return A.length + 1;
	}

}
