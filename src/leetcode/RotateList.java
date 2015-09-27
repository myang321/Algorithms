package leetcode;

import leetcode.model.ListNode;

public class RotateList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode rotateRight(ListNode head, int k) {
		ListNode newTail = null;
		ListNode newHead = null;
		int len = lenList(head);
		if (len == 0)
			return head;
		k = k % len;
		if (k == 0)
			return head;
		int cnt = 0;
		ListNode cur = head;
		// get new tail
		while (len - cnt > k) {
			newTail = cur;
			newHead = cur.next;
			cur = cur.next;
			cnt++;
		}
		// get tail
		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = head;
		newTail.next = null;
		return newHead;
	}

	private int lenList(ListNode head) {
		int cnt = 0;
		while (head != null) {
			cnt++;
			head = head.next;
		}
		return cnt;
	}
}
