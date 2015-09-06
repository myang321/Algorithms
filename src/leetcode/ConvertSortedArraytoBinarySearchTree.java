public class ConvertSortedArraytoBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null)
			return null;
		return helper(num, 0, num.length - 1);
	}

	private TreeNode helper(int[] num, int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		TreeNode node = new TreeNode(num[mid]);
		node.left = helper(num, start, mid - 1);
		node.right = helper(num, mid + 1, end);
		return node;
	}

}
