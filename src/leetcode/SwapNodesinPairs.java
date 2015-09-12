package leetcode;

public class SwapNodesinPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		System.out.println("aa");
		swapPairs(root);

	}

	public static ListNode swapPairs(ListNode head) {
		ListNode head1 = new ListNode(0);
		head1.next = head;
		ListNode head2 = head1;

		while (head1 != null && head1.next != null && head1.next.next != null) {
			ListNode n1 = head1;
			ListNode n2 = head1.next;
			ListNode n3 = head1.next.next;
			n1.next = n3;
			n2.next = n3.next;
			n3.next = n2;
			head1 = n2;
		}
		return head2.next;
	}
}
