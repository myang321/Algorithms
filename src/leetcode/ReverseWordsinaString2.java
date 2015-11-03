package leetcode;

public class ReverseWordsinaString2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWordsinaString2 r = new ReverseWordsinaString2();
		r.reverseWords(new String("hello world!").toCharArray());

	}

	// reverse the whole string, then reverse each word
	public void reverseWords(char[] s) {
		int len = s.length;
		// first, reverse whole string
		reverse(s, 0, len);
		int start = 0;
		// then, reverse each word
		// be careful about the last word
		for (int i = 0; i <= len; i++) {
			if (i == len || s[i] == ' ') {
				reverse(s, start, i - start);
				start = i + 1;
			}
		}
	}

	private void reverse(char[] s, int start, int len) {
		int end = start + len - 1;
		while (start < end) {
			char tmp = s[start];
			s[start] = s[end];
			s[end] = tmp;
			start++;
			end--;
		}
	}

}
