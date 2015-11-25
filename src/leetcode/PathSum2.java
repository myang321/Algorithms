package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.model.TreeNode;

public class PathSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PathSum2 p = new PathSum2();
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		p.pathSum(t, 0);

	}

	private List<List<Integer>> result;
	private int target;

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		this.target = sum;
		result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;
		List<Integer> list = new ArrayList<Integer>();
		list.add(root.val);
		dfs(root, list, root.val);
		return result;
	}

	private void dfs(TreeNode root, List<Integer> path, int sum) {
		if (root.left == null && root.right == null) {
			if (sum == target)
				result.add(path);
			return;
		}
		if (root.left != null) {
			List<Integer> path2 = new ArrayList<Integer>(path);
			path2.add(root.left.val);
			dfs(root.left, path2, sum + root.left.val);
		}
		if (root.right != null) {
			List<Integer> path2 = new ArrayList<Integer>(path);
			path2.add(root.right.val);
			dfs(root.right, path2, sum + root.right.val);
		}
	}
	// public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
	// ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();
	// if (root == null)
	// return tmp;
	// MyReturn ret = dfs(root, sum);
	// if (ret.arr == null)
	// return tmp;
	// return ret.arr;
	// }
	//
	// public MyReturn dfs(TreeNode root, int sum) {
	// if (root.left == null && root.right == null) {
	// if (sum == root.val) {
	// MyReturn m = new MyReturn(true);
	// m.add(root.val);
	// return m;
	// }
	// return new MyReturn(false);
	// }
	// MyReturn flag1 = null;
	// MyReturn flag2 = null;
	// if (root.left != null) {
	// flag1 = dfs(root.left, sum - root.val);
	// }
	// if (root.right != null) {
	// flag2 = dfs(root.right, sum - root.val);
	// }
	// if (root.left != null && root.right != null) {
	// if (flag1.flag == true && flag2.flag == false) {
	// flag1.add(root.val);
	// return flag1;
	// } else if (flag1.flag == false && flag2.flag == true) {
	// flag2.add(root.val);
	// return flag2;
	// } else if (flag1.flag == true && flag2.flag == true) {
	// flag1.arr.addAll(flag2.arr);
	// flag1.add(root.val);
	// return flag1;
	// } else {
	// return new MyReturn(false);
	// }
	// } else if (root.left != null && flag1.flag == true) {
	// flag1.add(root.val);
	// return flag1;
	// } else if (root.right != null && flag2.flag == true) {
	// flag2.add(root.val);
	// return flag2;
	// }
	// return new MyReturn(false);
	//
	// }
}

// class MyReturn {
// public boolean flag;
// public ArrayList<ArrayList<Integer>> arr;
//
// public MyReturn(boolean flag) {
// if (flag == false)
// this.flag = false;
// else {
// this.flag = true;
// arr = new ArrayList<ArrayList<Integer>>();
// arr.add(new ArrayList<Integer>());
// }
// }
//
// public void add(int val) {
// for (ArrayList<Integer> a : arr) {
// a.add(0, val);
// }
// }
// }
