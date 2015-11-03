package leetcode;

import leetcode.model.TreeNode;

public class BinaryTreeLongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Given a binary tree, find the length of the longest consecutive sequence
	// path.
	//
	// The path refers to any sequence of nodes from some starting node to any
	// node in the tree along the parent-child connections. The longest
	// consecutive path need to be from parent to child (cannot be the reverse).
	//
	// For example,
//	   1
//	    \
//	     3
//	    / \
//	   2   4
//	        \
//	         5
	// Longest consecutive sequence path is 3-4-5, so return 3.
//	   2
//	    \
//	     3
//	    / 
//	   2    
//	  / 
//	 1
	// Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
	private int max;

	public int longestConsecutive(TreeNode root) {
		max = 0;
		helper(root, null, 0);
		return max;
	}

	public void helper(TreeNode root, Integer prev, int len) {
		if (root == null)
			return;
		if (prev == null) {
			len = 1;
		} else {
			if (root.val == prev + 1) {
				len++;
			} else {
				len = 1;
			}
		}
		max = Math.max(max, len);
		prev = root.val;
		if (root.left != null)
			helper(root.left, prev, len);
		if (root.right != null)
			helper(root.right, prev, len);
	}

}
