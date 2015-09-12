package leetcode;

import leetcode.model.TreeNode;

public class LowestCommonAncestorofaBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (p.val < root.val && q.val < root.val)
			return lowestCommonAncestor(root.left, p, q);
		if (p.val > root.val && q.val > root.val)
			return lowestCommonAncestor(root.right, p, q);
		return root;
	}

}
