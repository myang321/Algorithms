package leetcode;

import leetcode.model.ListNode;

public class InsertionSortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertionSortList is = new InsertionSortList();
		ListNode head = new ListNode(Integer.MIN_VALUE + 1);
		ListNode node2 = new ListNode(Integer.MIN_VALUE);
		// ListNode node3 = new ListNode(1);
		// ListNode node4 = new ListNode(3);
		head.next = node2;
		// node2.next = node3;
		// node3.next = node4;
		is.insertionSortList(head);
	}

	public ListNode insertionSortList(ListNode head) {
		ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
		dummyHead.next = head;
		ListNode cur = head;
		ListNode prev = dummyHead;
		while (cur != null) {
			ListNode next = cur.next;
			// continue if prev<=cur
			if (prev.val <= cur.val) {
				prev = cur;
				cur = next;
				continue;
			}
			ListNode cur2 = dummyHead;
			boolean flag = false;
			while (cur2 != null) {
				if (cur == cur2 || cur == cur2.next) {
					cur2 = cur2.next;
					continue;
				}
				if (cur2.val <= cur.val
						&& (cur2.next == null || cur.val <= cur2.next.val)) {
					insertAfter(cur2, cur);
					if (prev != null)
						prev.next = next;
					cur = head;
					prev = dummyHead;
					flag = true;
					break;
				}
				cur2 = cur2.next;
			}
			if (!flag) {
				prev = cur;
				cur = next;
			} else {
				flag = false;
				continue;
			}
		}
		return dummyHead.next;
	}

	private void insertAfter(ListNode head, ListNode node) {
		ListNode next = head.next;
		head.next = node;
		node.next = next;
	}

}
