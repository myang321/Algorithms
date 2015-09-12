package leetcode;

import leetcode.model.ListNode;

public class Delete_duplicates_from_sorted_list {



	public static void main(String[] args) {

		ListNode L = new ListNode(1);
		L.next = new ListNode(2);

		deleteDuplicates(L);

	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next==null)
			return head;
		ListNode p = head.next;
		while (p != null && head.val == p.val) {
			p = p.next;
		}
		head.next = deleteDuplicates(p);
		return head;
	}
	

}


