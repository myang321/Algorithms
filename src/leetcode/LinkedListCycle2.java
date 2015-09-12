package leetcode;

import leetcode.model.ListNode;

public class LinkedListCycle2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;
		ListNode fast = head;
		ListNode slow = head;
		do {
			if (fast.next == null || fast.next.next == null)
				return null;
			slow = slow.next;
			fast = fast.next.next;
		} while (fast != slow);
		while (fast != head) {
			fast = fast.next;
			head = head.next;
		}
		return head;
	}
}
