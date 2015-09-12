package leetcode;
import java.util.ArrayList;

public class SummaryRanges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<String> summaryRanges(int[] nums) {
		ArrayList<String> result = new ArrayList<String>();
		if (nums.length == 0)
			return result;
		if (nums.length == 1) {
			result.add("" + nums[0]);
			return result;
		}
		int start = nums[0];
		int end = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1] + 1) {
				end = nums[i];
			} else {
				result.add(convertStr(start, end));
				start = end = nums[i];
			}
		}
		result.add(convertStr(start, end));
		return result;
	}

	public String convertStr(int start, int end) {
		if (start == end)
			return "" + start;
		else
			return start + "->" + end;
	}

}
