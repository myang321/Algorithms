package leetcode;

public class ReverseLinkedList2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLinkedList2 r = new ReverseLinkedList2();
		ListNode head = new ListNode(3);
		head.next = new ListNode(5);
		r.reverseBetween(head, 1, 2);
		System.out.println("111");
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null)
			return null;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode before = null;
		ListNode after = null;
		ListNode before1 = null;
		ListNode after1 = null;
		ListNode p = dummy;
		for (int i = 0; i < m; i++) {
			before = p;
			p = p.next;
		}
		after1 = p;
		ListNode prev = null;
		if (n - m == 0)
			return head;
		for (int i = 0; i < n - m; i++) {
			ListNode tmp = p.next;
			after = tmp.next;
			p.next = prev;
			prev = p;
			p = tmp;
		}
		p.next = prev;
		before1 = p;
		before.next = before1;
		if (after1 != null)
			after1.next = after;
		return dummy.next;
	}

}
