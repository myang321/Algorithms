package leetcode;

public class CopyListwithRandomPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;
		// original list's current
		RandomListNode orgCur = head;

		// step 1: create copy list, link 2 lists together
		// original list: A->B->C
		// new list: A->copyA->B->copyB->C->copyC
		while (orgCur != null) {
			RandomListNode copyCur = new RandomListNode(orgCur.label);
			RandomListNode orgNext = orgCur.next;
			orgCur.next = copyCur;
			copyCur.next = orgNext;
			orgCur = orgNext;
		}

		// step 2: create random link for copy list
		orgCur = head;
		while (orgCur != null) {
			if (orgCur.random != null)
				orgCur.next.random = orgCur.random.next;
			orgCur = orgCur.next.next;
		}

		// step 3: separate two list
		RandomListNode cur = head;
		RandomListNode copyHead = head.next;
		while (cur != null && cur.next != null) {
			RandomListNode next = cur.next;
			cur.next = next.next;
			cur = next;
		}
		return copyHead;
	}
}
