package leetcode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import leetcode.model.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		BinaryTreeZigzagLevelOrderTraversal b = new BinaryTreeZigzagLevelOrderTraversal();
		b.zigzagLevelOrder(root);
	}

	ArrayList<ArrayList<Integer>> arr;
	ArrayList<Integer> a;

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null)
			return new ArrayList<ArrayList<Integer>>();
		LinkedList<TreeNode> qt = new LinkedList<TreeNode>();
		LinkedList<Integer> qi = new LinkedList<Integer>();
		arr = new ArrayList<ArrayList<Integer>>();
		a = new ArrayList<Integer>();
		qt.add(root);
		qi.add(1);
		int oldi = 1;
		while (!qt.isEmpty()) {
			TreeNode tmpt = qt.pop();
			int tmpi = qi.pop();
			if (tmpt.left != null) {
				qt.add(tmpt.left);
				qi.add(tmpi + 1);
			}
			if (tmpt.right != null) {
				qt.add(tmpt.right);
				qi.add(tmpi + 1);
			}
			if (tmpi != oldi) {
				arr.add(new ArrayList<Integer>(a));
				a.clear();
			}
			oldi = tmpi;
			if (tmpi % 2 == 1) {
				a.add(tmpt.val);
			} else {
				a.add(0, tmpt.val);
			}
		}
		if (!a.isEmpty()) {
			arr.add(new ArrayList<Integer>(a));
		}
		return arr;
	}

	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder2(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (root == null) {
			return result;
		}

		Stack<TreeNode> currLevel = new Stack<TreeNode>();
		Stack<TreeNode> nextLevel = new Stack<TreeNode>();
		Stack<TreeNode> tmp;

		currLevel.push(root);
		boolean normalOrder = true;

		while (!currLevel.isEmpty()) {
			ArrayList<Integer> currLevelResult = new ArrayList<Integer>();

			while (!currLevel.isEmpty()) {
				TreeNode node = currLevel.pop();
				currLevelResult.add(node.val);

				if (normalOrder) {
					if (node.left != null) {
						nextLevel.push(node.left);
					}
					if (node.right != null) {
						nextLevel.push(node.right);
					}
				} else {
					if (node.right != null) {
						nextLevel.push(node.right);
					}
					if (node.left != null) {
						nextLevel.push(node.left);
					}
				}
			}

			result.add(currLevelResult);
			tmp = currLevel;
			currLevel = nextLevel;
			nextLevel = tmp;
			normalOrder = !normalOrder;
		}

		return result;

	}

	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder3(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return result;
		boolean normal = true;
		Stack<TreeNode> current = new Stack<TreeNode>();
		Stack<TreeNode> next = null;
		current.push(root);
		while (!current.isEmpty()) {
			ArrayList<Integer> arr = new ArrayList<Integer>();
			next = new Stack<TreeNode>();
			while (!current.isEmpty()) {
				TreeNode tmp = current.pop();
				arr.add(tmp.val);
				if (normal) {
					if (tmp.left != null)
						next.push(tmp.left);
					if (tmp.right != null)
						next.push(tmp.right);
				} else {
					if (tmp.right != null)
						next.push(tmp.right);
					if (tmp.left != null)
						next.push(tmp.left);
				}
			}
			result.add(arr);
			current = next;
			normal = !normal;
		}
		return result;
	}
}
