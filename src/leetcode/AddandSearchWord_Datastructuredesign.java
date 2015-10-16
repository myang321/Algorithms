package leetcode;

public class AddandSearchWord_Datastructuredesign {

	public static void main(String[] args) {
		WordDictionary w = new WordDictionary();
		System.out.println("hello");
		w.addWord("at");
		System.out.println(w.search("a"));

	}
}

class WordDictionary {
	private class TrieNode {
		boolean isWord;
		TrieNode[] next;

		public TrieNode() {
			isWord = false;
			next = new TrieNode[26];
		}
	}

	public WordDictionary() {
		root = new TrieNode();
	}

	private TrieNode root;

	// Adds a word into the data structure.
	public void addWord(String word) {
		TrieNode cur = root;
		for (char c : word.toCharArray()) {
			if (cur.next[c - 'a'] == null)
				cur.next[c - 'a'] = new TrieNode();
			cur = cur.next[c - 'a'];
		}
		cur.isWord = true;
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		return search(word.toCharArray(), 0, root);
	}

	private boolean search(char[] array, int idx, TrieNode cur) {
		if (idx == array.length)
			return cur.isWord;
		char c = array[idx];
		if (c != '.') {
			if (cur.next[c - 'a'] == null)
				return false;
			return search(array, idx + 1, cur.next[c - 'a']);
		} else {
			for (int j = 0; j < 26; j++) {
				boolean result = false;
				if (cur.next[j] != null)
					result = search(array, idx + 1, cur.next[j]);
				if (result)
					return true;
			}
			return false;
		}
	}
}
// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
