package leetcode;

public class ShortestWordDistance3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortestWordDistance3 s = new ShortestWordDistance3();
		String[] words = { "practice", "makes", "perfect", "coding", "makes" };
		System.out.println(s.shortestWordDistance(words, "makes", "makes"));

	}

	// Given a list of words and two words word1 and word2, return the shortest
	// distance between these two words in the list.
	//
	// word1 and word2 may be the same and they represent two individual words
	// in the list.
	//
	// For example,
	//
	// Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
	//
	// Given word1 = "makes", word2 = "coding", return 1. Given word1 = "makes",
	// word2 = "makes", return 3.
	//
	// Note:
	//
	// You may assume word1 and word2 are both in the list.
	public int shortestWordDistance(String[] words, String word1, String word2) {
		int idx1 = -1;
		int idx2 = -1;
		int min = words.length;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				if (word1.equals(word2)) {
					idx1 = idx2;
					idx2 = i;
				} else
					idx1 = i;
			} else if (words[i].equals(word2))
				idx2 = i;

			if (idx1 != -1 && idx2 != -1)
				min = Math.min(min, Math.abs(idx1 - idx2));
		}
		return min;
	}
}
