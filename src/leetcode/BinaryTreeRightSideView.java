import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private ArrayList<Integer> array;

	public List<Integer> rightSideView(TreeNode root) {
		array = new ArrayList<Integer>();
		reversePreOrder(root, 0);
		return array;
	}

	private void reversePreOrder(TreeNode root, int dep) {
		if (root == null)
			return;
		if (dep == array.size()) {
			array.add(root.val);
		}
		reversePreOrder(root.right, dep + 1);
		reversePreOrder(root.left, dep + 1);
	}

}
