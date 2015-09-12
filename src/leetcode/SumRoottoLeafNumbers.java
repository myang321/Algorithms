package leetcode;

import leetcode.model.TreeNode;

class SumRoottoLeafNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int sumNumbers(TreeNode root) {
		return dfs(root, 0);
	}

	public int dfs(TreeNode root, int num) {
		if (root != null) {
			num *= 10;
			num += root.val;
			if (root.left == null && root.right == null)
				return num;
			return dfs(root.left, num) + dfs(root.right, num);
		} else {
			return 0;
		}
	}

}
