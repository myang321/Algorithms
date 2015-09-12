package leetcode;
import java.util.Stack;

public class BinarySearchTreeIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class BSTIterator {
	Stack<TreeNode> s;
	TreeNode current;

	public BSTIterator(TreeNode root) {
		s = new Stack<TreeNode>();
		current = root;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return current != null || !s.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		while (current != null) {
			s.push(current);
			current = current.left;
		}
		TreeNode tmp = s.pop();
		if (tmp.right != null){
			current=tmp.right;
		}
		return tmp.val;
	}
}
