import java.util.Arrays;

public class SingleNumber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// SingleNumber2 s = new SingleNumber2();
		// int[] A = { -2, -2, 3, -2 };
		// System.out.println(s.singleNumber(A));
		int a = 1 << 31;
		// a = a | Integer.MIN_VALUE;
		// String s = Integer.toBinaryString(a);
		// System.out.println(s);
		// System.out.println(s.length());
		System.out.println(a);
	}

	public int singleNumber1(int[] A) {
		int N = 3;
		int[] arr = new int[31];
		int neg = 0;
		Arrays.fill(arr, 0);
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < 32; j++) {
				if ((A[i] & (1 << j)) > 0)
					arr[j]++;
				arr[j] %= N;
			}
			if (A[i] < 0)
				neg++;
		}
		int num = 0;
		for (int j = 0; j < 31; j++) {
			if (arr[j] == 1) {
				num += (1 << j);
			}
		}
		if (neg % N == 1)
			num = num | Integer.MIN_VALUE;

		return num;
	}

	public int singleNumber(int[] A) {// TODO
		int N = 3;
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < 31; j++) {
				if ((A[i] & (1 << j)) > 0)
					sum = sum | (1 << j);
			}
		}
		return sum;
	}
}
