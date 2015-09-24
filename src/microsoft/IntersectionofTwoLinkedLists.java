package microsoft;

import leetcode.model.ListNode;

public class IntersectionofTwoLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// space: O(1)
	// time: O(n) at most 2 passes for each list
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		int len1 = listLen(headA);
		int len2 = listLen(headB);
		if (len1 > len2)
			headA = getN(headA, len1 - len2);
		else
			headB = getN(headB, len2 - len1);
		while (headA != null) {
			if (headA == headB)
				return headA;
			headA = headA.next;
			headB = headB.next;
		}
		return null;

	}

	private int listLen(ListNode head) {
		int cnt = 0;
		while (head != null) {
			cnt++;
			head = head.next;
		}
		return cnt;
	}

	private ListNode getN(ListNode head, int n) {
		while (n-- > 0) {
			head = head.next;
		}
		return head;
	}
}
