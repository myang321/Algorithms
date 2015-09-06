import java.util.LinkedList;

public class PopulatingNextRightPointersinEachNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		if (root.left != null)
			root.left.next = root.right;
		if (root.next != null && root.right != null)
			root.right.next = root.next.left;
		connect(root.left);
		connect(root.right);
	}

	public void connect2(TreeLinkNode root) {
		if (root == null)
			return;
		LinkedList<TreeLinkNode> qt = new LinkedList<TreeLinkNode>();
		LinkedList<Integer> qdep = new LinkedList<Integer>();
		qt.add(root);
		qdep.add(0);
		TreeLinkNode oldt = null;
		int olddep = 0;
		while (!qt.isEmpty()) {
			TreeLinkNode tmpt = qt.pop();
			int tmpdep = qdep.pop();
			if (oldt != null && olddep == tmpdep) {
				oldt.next = tmpt;
			} else {
				tmpt.next = null;
			}
			oldt = tmpt;
			olddep = tmpdep;
			if (tmpt.left != null) {
				qt.add(tmpt.left);
				qdep.add(tmpdep + 1);
			}
			if (tmpt.right != null) {
				qt.add(tmpt.right);
				qdep.add(tmpdep + 1);
			}
		}

	}
}
