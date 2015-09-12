package leetcode;

import leetcode.model.TreeNode;

public class InvertBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return root;
		TreeNode tmpLeft = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(tmpLeft);
		return root;
	}

}
