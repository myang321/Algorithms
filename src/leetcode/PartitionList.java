package leetcode;

import leetcode.model.ListNode;

public class PartitionList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode partition(ListNode head, int x) {
		ListNode leftDummy = new ListNode(-1);
		ListNode rightDummy = new ListNode(-1);
		ListNode left = leftDummy;
		ListNode right = rightDummy;
		while (head != null) {
			if (head.val < x) {
				left.next = head;
				left = left.next;
			} else {
				right.next = head;
				right = right.next;
			}
			head = head.next;
		}
		left.next = rightDummy.next;
		right.next = null;
		return leftDummy.next;
	}

}
