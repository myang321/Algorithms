import java.util.List;

public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		int a[][] = new int[n][n];
		for (int i=0;i<n;i++)
			a[n-1][i]=triangle.get(n-1).get(i);
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				a[i][j]=triangle.get(i).get(j)+Math.min(a[i+1][j],a[i+1][j+1]);
			}
		}
		return a[0][0];
	}

}
