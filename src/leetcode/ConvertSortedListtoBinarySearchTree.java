package leetcode;

import leetcode.model.ListNode;
import leetcode.model.TreeNode;

public class ConvertSortedListtoBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private ListNode current;

	public TreeNode sortedListToBST(ListNode head) {
		current = head;
		return helper(len(head));
	}

	private int len(ListNode head) {
		int cnt = 0;
		while (head != null) {
			head = head.next;
			cnt++;
		}
		return cnt;
	}

	private TreeNode helper(int size) {
		if (size <= 0)
			return null;
		TreeNode left = helper(size / 2);
		TreeNode root = new TreeNode(current.val);
		current = current.next;
		TreeNode right = helper(size - 1 - size / 2);
		root.left = left;
		root.right = right;
		return root;
	}
}
