package leetcode;
import java.util.HashSet;
import java.util.Iterator;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int longestConsecutive(int[] num) {
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int n : num) {
			hs.add(n);
		}
		int max = 1;
		for (int n : num) {
			int tmp = n;
			int current_max = 1;
			while (hs.contains(tmp + 1)) {
				tmp++;
				current_max++;
				hs.remove(tmp);
			}
			tmp = n;
			while (hs.contains(tmp - 1)) {
				tmp--;
				current_max++;
				hs.remove(tmp);
			}
			max = Math.max(max, current_max);
		}
		return max;
	}
}
