package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CourseSchedule cs = new CourseSchedule();
		int[][] prerequisites = { { 1, 0 }, { 2, 0 } };
		cs.canFinish(3, prerequisites);
	}

	// adjacency list
	// using adjacency matrix will TLE
	public ArrayList<Integer>[] matrix;
	public boolean visited[];
	public int len;

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		len = numCourses;
		matrix = new ArrayList[len];
		visited = new boolean[len];
		for (int i = 0; i < len; i++)
			matrix[i] = new ArrayList<Integer>();
		for (int i = 0; i < prerequisites.length; i++) {
			matrix[prerequisites[i][0]].add(prerequisites[i][1]);
		}
		for (int i = 0; i < len; i++) {
			// every time a dfs start, the visited matrix are all false
			if (!dfs(i))
				return false;
		}
		return true;
	}

	private boolean dfs(int j) {
		if (visited[j])
			return false;
		visited[j] = true;
		for (int i = 0; i < matrix[j].size(); i++) {
			if (!dfs(matrix[j].get(i)))
				return false;
		}
		visited[j] = false;
		return true;
	}

}
