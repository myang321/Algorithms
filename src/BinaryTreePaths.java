import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private ArrayList<String> result = new ArrayList<String>();

	public List<String> binaryTreePaths(TreeNode root) {
		if (root == null)
			return result;
		dfs(root, "", true);
		return result;
	}

	public void dfs(TreeNode root, String str, boolean first) {
		if (first)
			str = "" + root.val;
		else
			str = str + "->" + root.val;
		if (root.left == null && root.right == null)
			result.add(str);
		else {
			if (root.left != null)
				dfs(root.left, str, false);
			if (root.right != null)
				dfs(root.right, str, false);
		}
	}
}
