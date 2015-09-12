package leetcode;
import java.util.ArrayList;

public class Permutations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 1, 2, 3 };
		System.out.println(permute(a));
	}

	public static int DEP;
	public static int mark[];
	public static ArrayList<Integer> b;
	public static ArrayList<ArrayList<Integer>> arr;
	public static int[] NUM;

	public static ArrayList<ArrayList<Integer>> permute(int[] num) {
		DEP = num.length;
		mark = new int[DEP];
		b = new ArrayList<Integer>(DEP);
		for (int i=0;i<DEP;i++)
			b.add(0);
		arr = new ArrayList<ArrayList<Integer>>();
		NUM = num;
		dfs(0);
		return arr;

	}

	public static void dfs(int dep) {
		if (dep == DEP) {
			arr.add(new ArrayList<Integer>(b));
			return;
		}
		for (int i = 0; i < DEP; i++) {
			if (mark[i] == 0) {
				mark[i] = 1;
				b.set(dep, NUM[i]);
				dfs(dep + 1);
				mark[i] = 0;
			}
		}
	}

}
