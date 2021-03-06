package leetcode;

import leetcode.model.TreeNode;

public class ClosestBinarySearchTreeValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Given a non-empty binary search tree and a target value, find the value
	// in the BST that is closest to the target.
	//
	// Note:
	//
	// Given target value is a floating point.
	// You are guaranteed to have only one unique value in the BST that is
	// closest to the target.

	// min will be either current node, or one subtree
	public int closestValue(TreeNode root, double target) {
		int val = root.val;
		TreeNode next = null;
		if (target < val)
			next = root.left;
		else
			next = root.right;
		if (next == null)
			return val;
		int nextVal = closestValue(next, target);
		return Math.abs(target - nextVal) > Math.abs(target - val) ? val
				: nextVal;
	}
}
