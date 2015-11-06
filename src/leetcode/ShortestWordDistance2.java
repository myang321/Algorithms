package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ShortestWordDistance2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordDistance w = new WordDistance(new String[] { "a", "v", "b", "a" });
		System.out.println(w.shortest("a", "b"));

	}

	// This is a follow up of Shortest Word Distance. The only difference is now
	// you are given the list of words and your method will be called repeatedly
	// many times with different parameters. How would you optimize it?
	//
	// Design a class which receives a list of words in the constructor, and
	// implements a method that takes two words word1 and word2 and return the
	// shortest distance between these two words in the list.
	//
	// For example,
	// Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
	//
	// Given word1 = "coding¡±, word2 = "practice¡±, return 3.
	// Given word1 = "makes", word2 = "coding", return 1.
	//
	// Note:
	// You may assume that word1 does not equal to word2, and word1 and word2
	// are both in the list.

}

class WordDistance {
	private HashMap<String, List<Integer>> hm;

	public WordDistance(String[] words) {
		hm = new HashMap<String, List<Integer>>();
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			List<Integer> list = null;
			if (hm.containsKey(word)) {
				list = hm.get(word);
			} else {
				list = new LinkedList<Integer>();
			}
			list.add(i);
			hm.put(word, list);
		}
	}

	public int shortest(String word1, String word2) {
		int idx1 = -1;
		int idx2 = -1;
		Iterator<Integer> list1 = hm.get(word1).iterator();
		Iterator<Integer> list2 = hm.get(word2).iterator();
		idx1 = list1.next();
		idx2 = list2.next();
		int min = Math.abs(idx1 - idx2);
		while (list1.hasNext() || list2.hasNext()) {
			if (!list2.hasNext() || (idx1 < idx2 && list1.hasNext()))
				idx1 = list1.next();
			else
				idx2 = list2.next();
			min = Math.min(min, Math.abs(idx1 - idx2));
		}
		return min;
	}
}