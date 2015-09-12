package leetcode;
public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canJump(int[] A) {
		if (A.length==1)
			return true;
		int max = 0;
		for (int i = 0; i < A.length-1; i++) {
			max = Math.max(max - 1, A[i]);
			if (max==0)
				break;
		}
		return max>0;
	}

}
