package leetcode;

public class GraphValidTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private int[] parent;

	public boolean validTree(int n, int[][] edges) {
		parent = new int[n];
		for (int i = 0; i < n; i++)
			parent[i] = i;
		for (int i = 0; i < edges.length; i++) {
			int x = find(edges[i][0]);
			int y = find(edges[i][1]);
			// each edge is a bridge, two vertices should be in two different
			// connected
			// component before union
			if (x == y)
				return false;
			parent[x] = y;
		}
		// a tree should have n-1 edge
		return edges.length == n - 1;
	}

	private int find(int x) {
		while (parent[x] != x) {
			x = parent[x];
		}
		return x;
	}
}
