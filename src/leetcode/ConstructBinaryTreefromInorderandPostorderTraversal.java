package leetcode;

import leetcode.model.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructBinaryTreefromInorderandPostorderTraversal c = new ConstructBinaryTreefromInorderandPostorderTraversal();
		int[] inorder = { 1, 3, 2 };
		int[] postorder = { 3, 2, 1 };
		c.buildTree(inorder, postorder);

	}

	private int[] inorder;
	private int[] postorder;
	private int len;

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		this.inorder = inorder;
		this.postorder = postorder;
		this.len = inorder.length;
		return helper(len - 1, 0, len - 1);
	}

	private TreeNode helper(int postIdx, int inStart, int inEnd) {
		if (inStart > inEnd)
			return null;
		int inIdx = -1;
		// looking for the root in inorder
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == postorder[postIdx]) {
				inIdx = i;
				break;
			}
		}
		TreeNode cur = new TreeNode(postorder[postIdx]);
		int leftLen = inIdx - inStart;
		int rightLen = inEnd - inIdx;
		cur.left = helper(postIdx - rightLen - 1, inStart, inStart + leftLen
				- 1);
		cur.right = helper(postIdx - 1, inIdx + 1, inEnd);
		return cur;
	}
}
