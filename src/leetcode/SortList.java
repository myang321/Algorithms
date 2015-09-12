package leetcode;

public class SortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortList s = new SortList();
		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		s.sortList(head);
	}

	public ListNode sortList(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)// very important, missing this will cause stack
								// overflow
			return head;
		ListNode mid = findMid(head);
		ListNode right = sortList(mid.next);
		mid.next = null;
		ListNode left = sortList(head);
		head = merge(left, right);
		return head;
	}

	private ListNode findMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private ListNode merge(ListNode h1, ListNode h2) {
		ListNode dummy = new ListNode(-1);
		ListNode head = dummy;
		while (h1 != null && h2 != null) {
			if (h1.val < h2.val) {
				dummy.next = h1;
				h1 = h1.next;
			} else {
				dummy.next = h2;
				h2 = h2.next;
			}
			dummy = dummy.next;
		}
		if (h1 != null)
			dummy.next = h1;
		if (h2 != null)
			dummy.next = h2;
		return head.next;
	}

}
