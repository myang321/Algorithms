package leetcode;
import java.util.ArrayList;
import java.util.Stack;

import leetcode.model.TreeNode;

public class BinaryTreePostorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		postorderTraversal(root);

	}

	public static ArrayList<Integer> postorderTraversal(TreeNode root) {
		Stack s = new Stack();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		s.push(root);
		while (!s.isEmpty()) {
			Object o = s.pop();
			if (o == null)
				continue;
			TreeNode t;
			if (o instanceof Integer) {
				arr.add((Integer) o);
			} else {
				t = (TreeNode) o;
				s.add(t.val);// reverse order of post order
				s.add(t.right);
				s.add(t.left);
			}
		}
		return arr;
	}
}
