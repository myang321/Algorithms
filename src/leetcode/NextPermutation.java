package leetcode;
public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextPermutation n = new NextPermutation();
		int[] num = { 6, 2, 5, 4, 3, 1 };
		n.nextPermutation(num);

	}

	public void nextPermutation(int[] num) {
		int n = num.length;
		int i;
		// Reverse find first number which breaks descending order.
		for (i = n - 2; i >= 0; i--) {
			if (num[i] < num[i + 1])
				break;
		}
		if (i >= 0) {
			int j;
			// Exchange this number with the least number that's greater than
			// this number.
			for (j = i + 1; j < n && num[i] < num[j]; j++)
				;
			swap(num, i, j-1);
		}
		i++;
		// Reverse sort the numbers after the exchanged number
		for (int k = n - 1; i < k; i++, k--)
			swap(num, i, k);
	}

	public void swap(int[] num, int i, int j) {
		int tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}

}
