import java.util.ArrayList;
import java.util.List;

public class test1 {

	public static void main(String[] args) {
		test1 t = new test1();
//		t.dfs(1, 1, "");
		 t.dfs2(3, 3, "");
		for (String s : t.list)
			System.out.println(s);
	}

	public ArrayList<String> list = new ArrayList<String>();

	public void dfs(int left, int right, String s) {
		if (left == 0 && right == 0) {
			list.add(s);
			return;
		}
		if (left > 0) {
			dfs(left - 1, right, s + "(");
		}
		if (right > 0) {
			dfs(left, right - 1, s + ")");
		}
	}

	public void dfs2(int n, int remain, String s) {
		if (remain == 0) {
			list.add(s);
			return;
		}
		for (int i = 1; i <= n; i++) {
			dfs2(n, remain - 1, s + i);
		}
	}
}
