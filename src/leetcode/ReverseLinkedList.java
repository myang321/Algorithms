package leetcode;

import leetcode.model.ListNode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode reverseList(ListNode head) {
		// reach head==null only when whole list is null
		// reach head.next==null when reach the last node in the list
		if (head == null || head.next == null)
			return head;
		ListNode newHead = reverseList(head.next);
		// reverse the link, do it in reverse order
		head.next.next = head;
		// only work for the old head;
		head.next = null;
		return newHead;
	}

}
