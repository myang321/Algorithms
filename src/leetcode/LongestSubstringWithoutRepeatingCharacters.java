package leetcode;
import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring2(new String("abaab")));
	}

	public static int lengthOfLongestSubstring2(String s) {
		int array[] = new int[128];
		Arrays.fill(array, -1);
		int len = 0;
		int start = -1;
		for (int i = 0; i < s.length(); i++) {
			start = start >= array[s.charAt(i)] ? start : array[s.charAt(i)];
			len = (i - start) > len ? (i - start) : len;
			array[s.charAt(i)] = i;
		}
		return len;
	}

	public int lengthOfLongestSubstring(String s) {
		int array[] = new int[128];
		Arrays.fill(array, -1);
		int len = 0;
		int start = -1;// last duplicate point
		for (int i = 0; i < s.length(); i++) {
			if (start < array[s.charAt(i)])
				start = array[s.charAt(i)];
			if (i - start > len)
				len = i - start;
			array[s.charAt(i)] = i;
		}
		return len;
	}

}
