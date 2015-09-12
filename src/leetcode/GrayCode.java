package leetcode;
import java.util.ArrayList;

public class GrayCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrayCode g = new GrayCode();
		System.out.println(g.grayCode(3));
	}

	public ArrayList<Integer> grayCode1(int n) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int len = 1 << n;
		for (int i = 0; i < len; i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				int res = i / (1 << j);
				if (res % 4 == 1 || res % 4 == 2)
					sum += (1 << j);
			}
			result.add(sum);
		}
		return result;
	}

	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(0);
		for (int i = 0; i < n; i++) {
			int inc = 1 << i;
			for (int j = arr.size() - 1; j >= 0; j--) {
				arr.add(arr.get(j) + inc);
			}
		}
		return arr;
	}
}
