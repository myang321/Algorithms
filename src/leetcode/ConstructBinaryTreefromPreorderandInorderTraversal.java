package leetcode;

import leetcode.model.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructBinaryTreefromPreorderandInorderTraversal c = new ConstructBinaryTreefromPreorderandInorderTraversal();

		int[] preorder = { 1, 2 };
		int[] inorder = { 2, 1 };
		c.buildTree(preorder, inorder);
	}

	private int[] preorder;
	private int[] inorder;
	private int len;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		this.preorder = preorder;
		this.inorder = inorder;
		int len = inorder.length;
		this.len = len;
		return helper(0, 0, len - 1);
	}

	// preIdx: the root index in preorder
	private TreeNode helper(int preIdx, int inStart, int inEnd) {
		if (preIdx >= len || inStart > inEnd)
			return null;
		TreeNode cur = new TreeNode(preorder[preIdx]);
		int inIdx = -1;
		// find the cur in the inorder, left side are left tree, right size are
		// right tree
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == preorder[preIdx]) {
				inIdx = i;
				break;
			}
		}
		int leftSize = inIdx - inStart;
		cur.left = helper(preIdx + 1, inStart, inIdx - 1);
		cur.right = helper(preIdx + leftSize + 1, inIdx + 1, inEnd);
		return cur;
	}
}
