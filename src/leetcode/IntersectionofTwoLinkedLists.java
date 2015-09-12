package leetcode;

import leetcode.model.ListNode;

public class IntersectionofTwoLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21 };
		int b[] = { 2 };
		ListNode l1 = new ListNode(1);
		ListNode tmp = l1;
		tmp.next = new ListNode(3);
		tmp = tmp.next;
		tmp.next = new ListNode(5);
		tmp = tmp.next;
		tmp.next = new ListNode(7);
		tmp = tmp.next;
		tmp.next = new ListNode(9);
		tmp = tmp.next;
		tmp.next = new ListNode(11);
		tmp = tmp.next;
		tmp.next = new ListNode(13);
		tmp = tmp.next;
		ListNode l2 = new ListNode(2);
		getIntersectionNode2(l1, l2);

	}

	public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		ListNode result = null;
		if (headA == null || headB == null) {
			return null;
		}
		int a = 1, b = 1;
		while (headA.next != null) {
			a++;
			headA = headA.next;
		}
		while (headB.next != null) {
			b++;
			headB = headB.next;
		}
		int temp = 0;
		if (a >= b) {
			temp = a - b;
			while (temp != 0) {
				headA = headA.next;
				temp--;
			}
		} else {
			temp = b - a;
			while (temp != 0) {
				headB = headB.next;
				temp--;
			}
		}
		while (headA != null) {
			if (headA == headB) {
				result = headA;
				break;
			} else {
				headA = headA.next;
				headB = headB.next;
			}
		}
		return result;
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int len1 = length(headA);
		int len2 = length(headB);
		if (len1 > len2) {
			while (len1 > len2) {
				headA = headA.next;
				len1--;
			}
		}
		if (len1 < len2) {
			while (len1 < len2) {
				headB = headB.next;
				len2--;
			}
		}
		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
	}

	private int length(ListNode root) {
		int cnt = 0;
		while (root != null) {
			root = root.next;
			cnt++;
		}
		return cnt;
	}

}
