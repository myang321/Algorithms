package leetcode;

public class PalindromePermutation {

	// Given a string, determine if a permutation of the string could form a
	// palindrome.
	//
	// For example,
	// "code" -> False, "aab" -> True, "carerac" -> True.
	//
	// Hint:
	//
	// Consider the palindromes of odd vs even length. What difference do you
	// notice?
	// Count the frequency of each character.
	// If each character occurs even number of times, then it must be a
	// palindrome. How about character which occurs odd number of times?
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// can have no more than one char that appear odd times
	public boolean canPermutePalindrome(String s) {
		int[] hashMap = new int[256];
		for (char c : s.toCharArray()) {
			hashMap[c - 'a']++;
		}
		// cnt odd
		int cnt = 0;
		for (int i = 0; i < 26; i++)
			if (hashMap[i] % 2 == 1)
				cnt++;
		return cnt <= 1;
	}
}
