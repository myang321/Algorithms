package leetcode;
public class UniquePaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int uniquePaths(int m, int n) {
		int [][]f= new int [101][101];
		init(f);
		return f[m][n];
	}

	void init(int[][] f) {
		for (int i=1;i<=100;i++)
			f[i][1]=f[1][i]=1;
		for (int i=2;i<=100;i++)
			for (int j=2;j<=100;j++){
				f[i][j]=f[i-1][j]+f[i][j-1];
			}
	}

}
