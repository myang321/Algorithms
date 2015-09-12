package leetcode;
import java.util.ArrayList;
import java.util.LinkedList;

import leetcode.model.TreeNode;

public class BinaryTreeLevelOrderTraversal2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(1);
		levelOrderBottom(root);
	}

	public static ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		LinkedList<TreeNode> qt = new LinkedList<TreeNode>();
		LinkedList<Integer> qi = new LinkedList<Integer>();
		ArrayList<Integer> a = new ArrayList<Integer>();
		if (root==null)
			return arr;
		qt.add(root);
		qi.add(0);
		int last = 0;
		while (!qt.isEmpty()) {
			TreeNode tmp = qt.pop();
			int dep = qi.pop();
			if (dep != last) {
				arr.add(0, a);
				a = new ArrayList<Integer>();
			}
			last=dep;
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
		if (a.size()>0)
			arr.add(0, a);	
		return arr;
	}
}
