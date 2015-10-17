package others;

import leetcode.model.TreeLinkNode;

public class BinarySearchTreeMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// find if t2 is a subtree of t1
	// both are binary search tree
	// compare value not reference
	public boolean f(TreeLinkNode t1, TreeLinkNode t2) {
		// find t2.val in t1
		TreeLinkNode commonRoot = findRoot(t1, t2.val);
		if (commonRoot == null)
			return false;
		return isSame(commonRoot, t2);
	}

	private TreeLinkNode findRoot(TreeLinkNode root, int val) {
		if (root == null)
			return null;
		if (root.val == val)
			return root;
		if (root.val > val)
			return findRoot(root.left, val);
		else
			return findRoot(root.right, val);
	}

	private boolean isSame(TreeLinkNode t1, TreeLinkNode t2) {
		if (t1 == null && t2 == null)
			return true;
		if (t1 == null)
			return false;
		if (t2 == null)
			return false;
		if (t1.val != t2.val)
			return false;
		return isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
	}
}
