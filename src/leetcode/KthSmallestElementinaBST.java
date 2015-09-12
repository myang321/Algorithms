package leetcode;

import leetcode.model.TreeNode;

public class KthSmallestElementinaBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private int result;
	private int cnt;

	public int kthSmallest(TreeNode root, int k) {
		cnt = 0;
		inOrder(root, k);
		return result;
	}

	private void inOrder(TreeNode root, int k) {
		if (root == null)
			return;
		inOrder(root.left, k);
		cnt++;
		if (cnt == k) {
			result = root.val;
			return;
		}
		inOrder(root.right, k);
	}

}
