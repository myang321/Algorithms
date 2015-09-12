package leetcode;

public class RemoveDuplicatesfromSortedList2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesfromSortedList2 r = new RemoveDuplicatesfromSortedList2();
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(2);
		r.deleteDuplicates(root);

	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		dummy.val = head.val - 1;
		del(dummy);
		return dummy.next;
	}

	public ListNode del(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode p = head.next;
		if (p.val != head.val) {
			head.next = del(p);
			return head;
		} else {
			while (p != null && head.val == p.val) {
				p = p.next;
			}
			if (p == null)
				return null;
			return del(p);
		}
	}
}
