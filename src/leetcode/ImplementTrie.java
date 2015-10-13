package leetcode;

public class ImplementTrie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TrieNode {
	// Initialize your data structure here.
	public TrieNode[] next;
	public boolean isWord;

	public TrieNode() {
		next = new TrieNode[26];
		isWord = false;
	}
}

class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		TrieNode cur = root;
		for (char c : word.toCharArray()) {
			if (cur.next[c - 'a'] == null)
				cur.next[c - 'a'] = new TrieNode();
			cur = cur.next[c - 'a'];
		}
		cur.isWord = true;
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode cur = root;
		for (char c : word.toCharArray()) {
			if (cur.next[c - 'a'] == null)
				return false;
			cur = cur.next[c - 'a'];
		}
		return cur.isWord;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode cur = root;
		for (char c : prefix.toCharArray()) {
			if (cur.next[c - 'a'] == null)
				return false;
			cur = cur.next[c - 'a'];
		}
		return true;
	}
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
