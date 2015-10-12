package leetcode;

import leetcode.model.TreeNode;

public class LowestCommonAncestorofaBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return root;
		if (root == p || root == q)
			return root;
		TreeNode l = lowestCommonAncestor(root.left, p, q);
		TreeNode r = lowestCommonAncestor(root.right, p, q);
		// only the lca will have both l,r not null
		if (l != null && r != null)
			return root;
		if (l != null)
			return l;
		return r;
	}

}
