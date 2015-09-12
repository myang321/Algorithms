package leetcode;

public class RemoveNthNodeFromEndofList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		new RemoveNthNodeFromEndofList().removeNthFromEnd(head, 3);

	}

	public int N;

	class MutableInt {
		int i;
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		N = n;
		MutableInt mi = new MutableInt();
		return dfs(head, mi);
	}

	public ListNode dfs(ListNode head, MutableInt dep) {
		if (head == null) {
			dep.i = 0;
			return null;
		}
		ListNode next = dfs(head.next, dep);
		head.next = next;
		dep.i++;
		if (dep.i == N)
			return next;
		return head;
	}
}
