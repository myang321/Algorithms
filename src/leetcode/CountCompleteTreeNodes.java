package leetcode;

import leetcode.model.TreeNode;

public class CountCompleteTreeNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countNodes(TreeNode root) {
		int h = height(root);
		if (h == 0)
			return 0;
		int h_right = height(root.right);
		int left;
		int right;
		// left subtree is full
		if (h_right == h - 1) {
			left = (1 << (h - 1)) - 1;
			right = countNodes(root.right);
		}
		// right subtree is full with one less level
		// h_right==h-2
		else {
			left = countNodes(root.left);
			right = (1 << (h - 2)) - 1;
		}
		return left + right + 1;
	}

	private int height(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + height(root.left);
	}

}
