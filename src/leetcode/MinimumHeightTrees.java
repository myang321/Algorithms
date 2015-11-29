package leetcode;

import java.util.LinkedList;
import java.util.List;

public class MinimumHeightTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> result = new LinkedList<Integer>();
		// adjancy list
		List<Integer>[] adList = new LinkedList[n];
		int[] degree = new int[n];
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			adList[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < edges.length; i++) {
			int a = edges[i][0];
			int b = edges[i][1];
			degree[a]++;
			degree[b]++;
			adList[a].add(b);
			adList[b].add(a);
		}
		while (getMaxDegree(degree) > 1) {
			int[] degree2 = degree.clone();
			for (int i = 0; i < n; i++) {
				if (degree[i] == 1) {
					int to = adList[i].get(0);
					degree2[i] = 0;
					degree2[to]--;
					visited[i] = true;
					adList[i].remove(0);
					adList[to].remove(new Integer(i));
				}
			}
			degree = degree2;
		}
		for (int i = 0; i < n; i++)
			if (!visited[i])
				result.add(i);
		return result;
	}

	private int getMaxDegree(int[] array) {
		int maxDegree = 0;
		for (int i = 0; i < array.length; i++) {
			maxDegree = Math.max(maxDegree, array[i]);
		}
		return maxDegree;
	}
}
