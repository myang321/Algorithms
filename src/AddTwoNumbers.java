public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (listLen(l1) < listLen(l2)) {
			ListNode tmpl = l1;
			l1 = l2;
			l2 = tmpl;
		}
		int carry = 0;
		int sum;
		ListNode head = l1;
		ListNode last = l1;
		while (l1 != null) {
			int l2val = 0;
			if (l2 != null)
				l2val = l2.val;
			sum = l1.val + l2val + carry;
			carry = sum / 10;
			sum %= 10;
			l1.val = sum;
			last = l1;
			l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}
		if (carry != 0) {
			last.next = new ListNode(carry);
		}
		return head;
	}

	public int listLen(ListNode l1) {
		int len = 0;
		while (l1 != null) {
			len++;
			l1 = l1.next;
		}
		return len;
	}
}
