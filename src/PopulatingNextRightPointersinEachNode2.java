public class PopulatingNextRightPointersinEachNode2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// when we are in level N, we create "next" link for level N+1
	public void connect(TreeLinkNode root) {
		// current node in current level
		TreeLinkNode curr = root;
		// current node in next level
		TreeLinkNode nextCurr = null;
		// head of next level
		TreeLinkNode nextHead = null;
		while (curr != null) {
			nextCurr = null;
			nextHead = null;
			while (curr != null) {
				if (curr.left != null) {
					// if nextCurr is null, nextHead is also null
					if (nextCurr != null)
						nextCurr.next = curr.left;// create next link for next
													// level
					else
						nextHead = curr.left;
					nextCurr = curr.left;
				}
				if (curr.right != null) {
					// if nextCurr is null, nextHead is also null
					if (nextCurr != null)
						nextCurr.next = curr.right;// create next link for next
													// level
					else
						nextHead = curr.right;
					nextCurr = curr.right;
				}
				curr = curr.next;
			}
			curr = nextHead;
		}
	}
}
