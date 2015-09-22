package microsoft;

import java.util.List;

import leetcode.model.ListNode;

public class MergekSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private ListNode mergeTwoSortedList(ListNode head1, ListNode head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;
		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				current.next = head1;
				head1 = head1.next;
				current = current.next;
			} else {
				current.next = head2;
				head2 = head2.next;
				current = current.next;
			}
		}
		if (head1 != null)
			current.next = head1;
		if (head2 != null)
			current.next = head2;
		return dummy.next;
	}

	public ListNode mergeKLists(ListNode[] lists) {
		return helper(lists, 0, lists.length);
	}

	private ListNode helper(ListNode[] lists, int begin, int end) {
		int len = end - begin;
		if (len == 0)
			return null;
		if (len == 1)
			return lists[begin];
		int mid = (begin + end) / 2;
		ListNode head1 = helper(lists, begin, mid);
		ListNode head2 = helper(lists, mid, end);
		return mergeTwoSortedList(head1, head2);

	}
}
