package leetcode;
import java.util.ArrayList;
import java.util.Stack;

import leetcode.model.TreeNode;

public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		Stack s = new Stack();
		ArrayList<Integer> a = new ArrayList<Integer>();
		s.push(root);
		while (!s.empty()) {
			Object tmpo = s.pop();
			if (tmpo == null)
				continue;
			if (tmpo instanceof Integer) {
				a.add((Integer) tmpo);
			} else {
				TreeNode t = (TreeNode) tmpo;
				s.push(t.right);// reverse order of inorders
				s.push(new Integer(t.val));
				s.push(t.left);
			}
		}
		return a;
	}

}
