package leetcode;

public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidateBinarySearchTree v = new ValidateBinarySearchTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		v.isValidBST(root);
	}

	public boolean isValid;

	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		this.isValid = true;
		dfs_high(root);
		dfs_low(root);
		return this.isValid;
	}

	public int dfs_high(TreeNode root) {// left
		int left = Integer.MIN_VALUE;
		int right = Integer.MIN_VALUE;
		if (root.left != null) {
			left = dfs_high(root.left);
		}
		if (root.right != null) {
			right = dfs_high(root.right);
		}
		if (left >= root.val) {
			this.isValid = false;
			return -1;
		}
		return Math.max(Math.max(left, right), root.val);
	}

	public int dfs_low(TreeNode root) {// right
		int left = Integer.MAX_VALUE;
		int right = Integer.MAX_VALUE;
		if (root.left != null) {
			left = dfs_low(root.left);
		}
		if (root.right != null) {
			right = dfs_low(root.right);
		}
		if (right <= root.val) {
			this.isValid = false;
			return -1;
		}
		return Math.min(Math.min(left, right), root.val);
	}

	public int lastVal;
	public boolean firstNode = true;

	public boolean bestSolution(TreeNode root) {
		if (root == null)
			return true;
		if (!isValidBST(root.left))
			return false;
		if (firstNode) {
			firstNode = false;
		} else if (lastVal >= root.val)
			return false;
		lastVal = root.val;
		if (!isValidBST(root.right))
			return false;
		return true;
	}

}
