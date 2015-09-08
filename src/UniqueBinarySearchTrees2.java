import java.util.ArrayList;

public class UniqueBinarySearchTrees2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateTrees(3);

	}

	public static void copyAdd(TreeNode root, TreeNode newRoot, int n) {
		if (root == null)
			return;
		newRoot.val = root.val + n;
		if (root.left != null) {
			TreeNode node = new TreeNode(0);
			newRoot.left = node;
			copyAdd(root.left, node, n);
		}
		if (root.right != null) {
			TreeNode node = new TreeNode(0);
			newRoot.right = node;
			copyAdd(root.right, node, n);
		}
	}

	public static ArrayList<TreeNode> generateTrees(int n) {
		ArrayList<ArrayList<TreeNode>> lists = new ArrayList<ArrayList<TreeNode>>();
		ArrayList<TreeNode> list0 = new ArrayList<TreeNode>();
		list0.add(null);
		ArrayList<TreeNode> list1 = new ArrayList<TreeNode>();
		TreeNode node = new TreeNode(1);
		list1.add(node);
		lists.add(list0);
		lists.add(list1);
		for (int i = 2; i <= n; i++) {
			ArrayList<TreeNode> newList = new ArrayList<TreeNode>();
			// root value
			for (int j = 1; j <= i; j++) {
				ArrayList<TreeNode> leftList = lists.get(j - 1);
				ArrayList<TreeNode> rightList = lists.get(i - j);
				for (TreeNode left : leftList) {
					for (TreeNode right : rightList) {
						TreeNode nodeTmp = new TreeNode(j);
						TreeNode newRight = null;
						if (right != null) {
							newRight = new TreeNode(0);
							copyAdd(right, newRight, j);
						}
						nodeTmp.left = left;
						nodeTmp.right = newRight;
						newList.add(nodeTmp);
					}

				}
			}
			lists.add(newList);
		}
		return lists.get(n);
	}
}
