package leetcode;
import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

	public static void main(String[] args) {
		String s = "010010";
		// System.out.println(s.substring(0, 1));
		RestoreIPAddresses r = new RestoreIPAddresses();
		System.out.println(r.restoreIpAddresses(s));
	}

	private ArrayList<String> array;

	public List<String> restoreIpAddresses(String s) {
		array = new ArrayList<String>();
		dfs(s, 1, "");
		return array;
	}

	private void dfs(String remainStr, int dep, String result) {
		// dep=1,2,3
		if (remainStr.isEmpty())
			return;
		if (dep < 4) {
			int num = 0;
			for (int i = 0; i < remainStr.length(); i++) {
				int cur = remainStr.charAt(i) - '0';
				num = num * 10 + cur;
				if (num < 256)
					dfs(remainStr.substring(i + 1), dep + 1, result + num + ".");
				else
					return;
				if (num == 0)
					break;
			}
		} else {
			int num = 0;
			char[] charArray = remainStr.toCharArray();
			for (int i = 0; i < charArray.length; i++) {
				if (i > 0 && num == 0)
					return;
				int cur = remainStr.charAt(i) - '0';
				num = num * 10 + cur;
				if (num > 255)
					return;
			}
			result = result + num;
			array.add(result);
		}
	}

}
