public class PathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PathSum p = new PathSum();
		TreeNode root = null;
		p.hasPathSum(root, 0);

	}

	public boolean isExist;
	public int SUM;

	public boolean hasPathSum(TreeNode root, int sum) {
		this.isExist = false;
		this.SUM = sum;
		if (root == null)
			return false;
		dfs(root, 0);
		return this.isExist;
	}

	public void dfs(TreeNode root, int sum) {
		if (this.isExist)
			return;
		if (root == null) {
			return;
		}
		sum += root.val;
		if (root.left == null && root.right == null) {
			if (sum == this.SUM)
				this.isExist = true;
			return;
		}
		dfs(root.left, sum);
		dfs(root.right, sum);
	}

}
