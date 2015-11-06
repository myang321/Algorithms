package leetcode;

public class FlipGame2 {

	// You are playing the following Flip Game with your friend: Given a string
	// that contains only these two characters: + and -, you and your friend
	// take turns to flip two consecutive "++" into "--". The game ends when a
	// person can no longer make a move and therefore the other person will be
	// the winner.
	//
	// Write a function to determine if the starting player can guarantee a win.
	//
	// For example, given s = "++++", return true. The starting player can
	// guarantee a win by flipping the middle "++" to become "+--+".
	//
	// Follow up:
	// Derive your algorithm's runtime complexity.

	public static void main(String[] args) {
		FlipGame2 f = new FlipGame2();
		String s = "+-+-+-+-+-+-+-+-+-+-";
		System.out.println(f.canWin(s));
	}

	private char[] arr;
	private int len;

	public boolean canWin(String s) {
		arr = s.toCharArray();
		len = arr.length;
		return canWin();
	}

	private boolean canWin() {
		for (int i = 0; i < len - 1; i++) {
			if (arr[i] == '+' && arr[i + 1] == '+') {
				arr[i] = arr[i + 1] = '-';
				// opposite of opponent's result
				boolean win = !canWin();
				arr[i] = arr[i + 1] = '+';
				if (win)
					return true;
			}
		}
		return false;
	}

}
