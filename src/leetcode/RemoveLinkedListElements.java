package leetcode;

import leetcode.model.ListNode;

public class RemoveLinkedListElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode removeElements(ListNode head, int val) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode current = dummyHead;
		while (current != null && current.next != null) {
			if (current.next.val == val) {
				current.next = current.next.next;
			} else
				current = current.next;
		}
		return dummyHead.next;
	}

}
