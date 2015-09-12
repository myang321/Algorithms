package leetcode;

import leetcode.model.ListNode;

public class LinkedListCycle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		ListNode slow = head;
		ListNode fast = head.next;
		while (slow != fast) {
			if (slow.next == null || fast.next == null
					|| fast.next.next == null)
				return false;
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}

}
