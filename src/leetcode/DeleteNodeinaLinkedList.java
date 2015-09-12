package leetcode;

import leetcode.model.ListNode;

public class DeleteNodeinaLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void deleteNode(ListNode node) {
		ListNode next = node.next;
		node.val = next.val;
		node.next = next.next;
	}

}
