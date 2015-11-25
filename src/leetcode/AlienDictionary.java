package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlienDictionary a = new AlienDictionary();
		String[] words = { "wrt", "wrf", "er", "ett", "rftt" };
		System.out.println(a.alienOrder(words));

	}

	private String[] words;
	// adjency list
	private HashSet<Integer>[] adList;
	private int[] inDegree;
	private StringBuffer result;
	private int len;
	private HashSet<Integer> letters;

	public String alienOrder(String[] words) {
		this.words = words;
		adList = new HashSet[26];
		inDegree = new int[26];
		letters = new HashSet<Integer>();
		for (int i = 0; i < 26; i++)
			adList[i] = new HashSet<Integer>();
		makeGraph(Arrays.asList(words), 0);
		len = letters.size();
		result = new StringBuffer();
		bfs();
		return result.toString();
	}

	private void bfs() {
		Queue<Integer> q = new LinkedList<>();
		int cnt = 0;
		for (int i : letters) {
			if (inDegree[i] == 0)
				q.add(i);
		}
		while (!q.isEmpty()) {
			int from = q.remove();
			result.append((char) ('a' + from));
			cnt++;
			for (int to : adList[from]) {
				inDegree[to]--;
				if (inDegree[to] == 0)
					q.add(to);
			}
		}
		if (cnt != len)
			result = new StringBuffer();
	}

	private void makeGraph(List<String> strs, int dep) {
		ArrayList<String> lists[] = new ArrayList[26];
		for (int i = 0; i < 26; i++)
			lists[i] = new ArrayList<String>();
		for (int i = 0; i < strs.size(); i++) {
			int from = strs.get(i).charAt(dep) - 'a';
			letters.add(from);
			if (strs.get(i).length() > dep + 1)
				lists[from].add(strs.get(i));
			if (i == strs.size() - 1)
				break;
			int to = strs.get(i + 1).charAt(dep) - 'a';
			if (from != to && !adList[from].contains(to)) {
				adList[from].add(to);
				inDegree[to]++;
			}
		}
		for (ArrayList<String> list : lists) {
			if (list.size() != 0)
				makeGraph(list, dep + 1);
		}
	}
}
