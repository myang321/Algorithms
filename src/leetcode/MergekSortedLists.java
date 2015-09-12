package leetcode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists == null || lists.size() == 0)
			return null;
		PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(),
				new Comparator<ListNode>() {
					@Override
					public int compare(ListNode o1, ListNode o2) {
						if (o1.val < o2.val)
							return -1;
						else if (o1.val == o2.val)
							return 0;
						else
							return 1;
					}

				});
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;
		for (ListNode node : lists) {
			if (node != null)
				q.add(node);
		}
		while (!q.isEmpty()) {
			ListNode tmp = q.poll();
			if (tmp == null)
				continue;
			current.next = tmp;
			current = current.next;
			if (tmp.next != null)
				q.add(tmp.next);
		}
		return dummy.next;
	}

}
