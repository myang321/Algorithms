package leetcode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		LinkedList<TreeNode> qt = new LinkedList<TreeNode>();
		LinkedList<Integer> qi = new LinkedList<Integer>();
		ArrayList<Integer> a = new ArrayList<Integer>();
		if (root == null)
			return arr;
		qt.add(root);
		qi.add(0);
		int last = 0;
		while (!qt.isEmpty()) {
			int dep = qi.pop();
			TreeNode tmp = qt.pop();
			if (last != dep) {
				arr.add(a);
				a = new ArrayList<Integer>();
			}
			last = dep;
			a.add(tmp.val);
			if (tmp.left != null) {
				qt.add(tmp.left);
				qi.add(dep + 1);
			}
			if (tmp.right != null) {
				qt.add(tmp.right);
				qi.add(dep + 1);
			}
		}
		if (a.size() > 0)
			arr.add(a);
		return arr;
	}

	public ArrayList<ArrayList<Integer>> levelOrder2(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return result;
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			ArrayList<Integer> a = new ArrayList<Integer>();
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode head = q.poll();
				a.add(head.val);
				if (head.left != null)
					q.add(head.left);
				if (head.right != null)
					q.add(head.right);
			}
			result.add(a);
		}
		return result;
	}

	public ArrayList<ArrayList<Integer>> levelOrder3(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return result;
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		LinkedList<TreeNode> next = null;
		current.add(root);
		while (!current.isEmpty()) {
			next = new LinkedList<TreeNode>();
			ArrayList<Integer> a = new ArrayList<Integer>();
			while (!current.isEmpty()) {
				TreeNode tmp = current.poll();
				a.add(tmp.val);
				if (tmp.left != null)
					next.add(tmp.left);
				if (tmp.right != null)
					next.add(tmp.right);
			}
			current = next;
			result.add(a);
		}
		return result;
	}
}
