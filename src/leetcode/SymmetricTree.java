package leetcode;
import java.util.LinkedList;

public class SymmetricTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return traversal(root.left, root.right);
	}

	boolean traversal(TreeNode leftRoot, TreeNode rightRoot) {
		if (leftRoot != null && rightRoot != null) {
			boolean b1 = (leftRoot.val == rightRoot.val);
			if (!b1)
				return false;
			boolean b2 = traversal(leftRoot.left, rightRoot.right);
			if (!b2)
				return false;
			boolean b3 = traversal(leftRoot.right, rightRoot.left);
			return b1 && b2 && b3;

		} else if (leftRoot == null && rightRoot == null)
			return true;
		else
			return false;
	}
	
	
	
	
	public boolean iterative(TreeNode root){
		if (root == null)
			return true;
		LinkedList<TreeNode> l1= new LinkedList<TreeNode>();
		LinkedList<TreeNode> l2= new LinkedList<TreeNode>();
		if (root.left!=null && root.right!=null){
			l1.add(root.left);
			l2.add(root.right);
		}else if (root.left==null && root.right==null)
			return true;
		else
			return false;
		while(!l1.isEmpty()){
			TreeNode t1=l1.pop();
			TreeNode t2=l2.pop();
			if (t1.val!=t2.val)
				return false;
			if (t1.left!=null && t2.right!=null){
				l1.add(t1.left);
				l2.add(t2.right);
			}else if (t1.left==null && t2.right==null){
				
			}else 
				return false;
			
			if (t1.right!=null && t2.left!=null){
				l1.add(t1.right);
				l2.add(t2.left);
			}else if (t1.right==null && t2.left==null){
				
			}else 
				return false;
		}
		return true;
	}
}
