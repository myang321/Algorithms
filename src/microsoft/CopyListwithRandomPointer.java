package microsoft;

import leetcode.RandomListNode;

public class CopyListwithRandomPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;

		// create copy list, link two list together
		RandomListNode cur = head;
		while (cur != null) {
			RandomListNode copyNode = new RandomListNode(cur.label);
			copyNode.next = cur.next;
			cur.next = copyNode;
			cur = copyNode.next;
		}

		RandomListNode copyHead = head.next;

		// create random pointer
		cur = head;
		while (cur != null) {
			if (cur.random != null)
				cur.next.random = cur.random.next;
			cur = cur.next.next;
		}

		// separate two lists
		cur = head;
		while (cur != null && cur.next != null) {
			RandomListNode nextNode = cur.next;
			cur.next = cur.next.next;
			cur = nextNode;
		}
		return copyHead;
	}

}
