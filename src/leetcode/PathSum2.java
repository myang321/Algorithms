import java.util.ArrayList;

public class PathSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PathSum2 p = new PathSum2();
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		p.pathSum(t, 0);

	}

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return tmp;
		MyReturn ret = dfs(root, sum);
		if (ret.arr == null)
			return tmp;
		return ret.arr;
	}

	public MyReturn dfs(TreeNode root, int sum) {
		if (root.left == null && root.right == null) {
			if (sum == root.val) {
				MyReturn m = new MyReturn(true);
				m.add(root.val);
				return m;
			}
			return new MyReturn(false);
		}
		MyReturn flag1 = null;
		MyReturn flag2 = null;
		if (root.left != null) {
			flag1 = dfs(root.left, sum - root.val);
		}
		if (root.right != null) {
			flag2 = dfs(root.right, sum - root.val);
		}
		if (root.left != null && root.right != null) {
			if (flag1.flag == true && flag2.flag == false) {
				flag1.add(root.val);
				return flag1;
			} else if (flag1.flag == false && flag2.flag == true) {
				flag2.add(root.val);
				return flag2;
			} else if (flag1.flag == true && flag2.flag == true) {
				flag1.arr.addAll(flag2.arr);
				flag1.add(root.val);
				return flag1;
			} else {
				return new MyReturn(false);
			}
		} else if (root.left != null && flag1.flag == true) {
			flag1.add(root.val);
			return flag1;
		} else if (root.right != null && flag2.flag == true) {
			flag2.add(root.val);
			return flag2;
		}
		return new MyReturn(false);

	}
}

class MyReturn {
	public boolean flag;
	public ArrayList<ArrayList<Integer>> arr;

	public MyReturn(boolean flag) {
		if (flag == false)
			this.flag = false;
		else {
			this.flag = true;
			arr = new ArrayList<ArrayList<Integer>>();
			arr.add(new ArrayList<Integer>());
		}
	}

	public void add(int val) {
		for (ArrayList<Integer> a : arr) {
			a.add(0, val);
		}
	}
}
