package others;

import leetcode.model.TreeLinkNode;

public class BinaryTreeMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// find if t2 is a subtree of t1
	// compare value not reference
	public static boolean isSubtreeValue(TreeLinkNode t1, TreeLinkNode t2) {
		if (t1 == null && t2 == null)
			return true;
		if (t1 == null || t2 == null)
			return false;
		if (t1.val == t2.val)
			if (isSameTree(t1, t2))
				return true;
		return isSubtreeValue(t1.left, t2) || isSubtreeValue(t1.right, t2);
	}

	private static boolean isSameTree(TreeLinkNode t1, TreeLinkNode t2) {
		if (t1 == null && t2 == null)
			return true;
		if (t1 == null)
			return false;
		if (t2 == null)
			return false;
		if (t1.val != t2.val)
			return false;
		return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
	}

}
