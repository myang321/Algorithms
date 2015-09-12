package leetcode;
import java.util.Scanner;


public class BalancedBinaryTree {

	/**
	 * @param args
	 */
	class MyBool{
		public MyBool(){
			this.balanced=true;
		}
		boolean balanced;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.println("please input the numbers");
        while(scan.hasNextInt())
        {
        	int a= scan.nextInt();
        	System.out.println(a);
        }
	}
	
	public boolean isBalanced(TreeNode root) {
		MyBool global_is_balanced = new MyBool();
		depth(root,global_is_balanced);
		return global_is_balanced.balanced;
    }
	
	int depth(TreeNode root, MyBool is_balanced ){
		if (is_balanced.balanced == false)
			return -1;
		if (root ==null)
			return 0;
		int left = depth(root.left,is_balanced);
		int right= depth(root.right,is_balanced);
		if (Math.abs(right-left)>1)
			is_balanced.balanced=false;
		return Math.max(left, right)+1;
	}
	
	

}
