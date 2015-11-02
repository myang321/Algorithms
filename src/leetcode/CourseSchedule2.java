package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CourseSchedule2 c = new CourseSchedule2();
		c.findOrder(2, new int[][] { { 0, 1 }, { 1, 0 } });

	}

	private ArrayList<Integer>[] adjacencyList;
	private int n;
	private int[] inDegree;
	private int[] topoSort;

	// We observe that if a node has incoming edges, it has prerequisites.
	// Therefore, the first few in the order must be those with no
	// prerequisites, i.e. no incoming edges. Any non-empty DAG must have at
	// least one node without incoming links. You can draw a small graph to
	// convince yourself. If we visit these few and remove all edges attached to
	// them, we are left with a smaller DAG, which is the same problem.
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		this.n = numCourses;
		this.inDegree = new int[n];
		this.adjacencyList = new ArrayList[n];
		this.topoSort = new int[n];
		for (int i = 0; i < n; i++)
			this.adjacencyList[i] = new ArrayList<Integer>();
		// prepare graph
		for (int i = 0; i < prerequisites.length; i++) {
			int in = prerequisites[i][0];
			int out = prerequisites[i][1];
			this.adjacencyList[out].add(in);
			inDegree[in]++;
		}
		if (bfs())
			return topoSort;
		return new int[0];
	}

	public boolean bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			if (inDegree[i] == 0)
				q.add(i);
		}
		int cnt = 0;
		while (!q.isEmpty()) {
			int idx = q.poll();
			topoSort[cnt++] = idx;
			for (int in : adjacencyList[idx]) {
				inDegree[in]--;
				if (inDegree[in] == 0)
					q.add(in);
			}
		}
		return cnt == n;
	}

}
