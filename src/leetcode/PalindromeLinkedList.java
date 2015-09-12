package leetcode;

import leetcode.model.ListNode;

public class PalindromeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeLinkedList pll = new PalindromeLinkedList();
		int[] nums = { 1, 2 };
		ListNode head = ListNode.createList(nums);
		System.out.println(pll.isPalindrome(head));
	}

	private boolean result = true;
	private ListNode middle1 = null;
	private ListNode middle2 = null;

	public boolean isPalindrome(ListNode head) {
		if (head == null)
			return result;
		this.middle1 = findMiddle1(head);
		this.middle2 = findMiddle2(head);
		check(head);
		return result;
	}

	private ListNode check(ListNode head) {
		if (head == this.middle1) {
			if (head.val != this.middle2.val) {
				this.result = false;
			}
			return this.middle2.next;
		}
		ListNode secondHalf = check(head.next);
		if (!result)
			return null;
		if (head.val != secondHalf.val) {
			this.result = false;
		}
		return secondHalf.next;
	}

	private ListNode findMiddle1(ListNode head) {
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private ListNode findMiddle2(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

}
