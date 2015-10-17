package others;

import leetcode.model.ListNode;

public class ReverseSecondHalfLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseSecondHalfLinkedList r = new ReverseSecondHalfLinkedList();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		r.reverse2ndHalf(node1);
		ListNode head = node1;
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}

	}

	public ListNode reverse2ndHalf(ListNode head) {
		ListNode mid = getMiddle(head);
		ListNode oldTail = reverseLinkedList(mid.next);
		mid.next = oldTail;
		return head;
	}

	private ListNode getMiddle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		ListNode preSlow = slow;
		while (fast != null && fast.next != null) {
			preSlow = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		return preSlow;
	}

	private ListNode reverseLinkedList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode newHead = reverseLinkedList(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
}
