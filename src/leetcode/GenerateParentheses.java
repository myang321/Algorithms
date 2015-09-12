package leetcode;
import java.util.ArrayList;

public class GenerateParentheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateParenthesis(3));

	}
	
	

	public static ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> list = new ArrayList<String>();
		dfs(list, 1, 0, n, new StringBuffer(""));
		return list;
	}

	public static void dfs(ArrayList<String> list, int dep, int val, int DEP,
			StringBuffer li) {
		if (dep == DEP) {
			li.append("(");
			for (int i = 0; i <= val; i++) {
				li.append(")");
			}
			list.add(li.toString());
			return;
		}
		li.append("(");
		val++;
		for (int i = 0; i <= val; i++) {
			if (i > 0)
				li.append(")");
			dfs(list, dep + 1, val - i, DEP, new StringBuffer(li));
		}

	}

}
