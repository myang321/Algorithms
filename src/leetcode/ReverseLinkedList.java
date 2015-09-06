public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode newHead = reverseList(head.next);
		head.next.next = head;
		// only work for the old head;
		head.next = null;
		return newHead;
	}

}
