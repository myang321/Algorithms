public class FlattenBinaryTreetoLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private TreeNode previous = null;

	public void flatten(TreeNode root) {
		if (root == null)
			return;
		if (previous != null) {
			previous.left = null;
			previous.right = root;
		}
		previous = root;
		TreeNode right = root.right;
		flatten(root.left);
		flatten(right);
	}

}
