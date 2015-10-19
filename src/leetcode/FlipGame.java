package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {

	public static void main(String[] args) {
		FlipGame f = new FlipGame();
		List<String> result = f.generatePossibleNextMoves("++++");
		System.out.println(result);

	}

	// You are playing the following Flip Game with your friend: Given a string
	// that contains only these two characters: + and -, you and your friend
	// take turns to flip twoconsecutive "++" into "--". The game ends when a
	// person can no longer make a move and therefore the other person will be
	// the winner.
	//
	// Write a function to compute all possible states of the string after one
	// valid move.
	//
	// For example, given s = "++++", after one move, it may become one of the
	// following states:
	//
	// [
	// "--++",
	// "+--+",
	// "++--"
	// ]
	// If there is no valid move, return an empty list [].

	public List<String> generatePossibleNextMoves(String s) {
		List<String> result = new ArrayList<String>();
		StringBuffer sb = new StringBuffer(s);
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
				sb.setCharAt(i, '-');
				sb.setCharAt(i + 1, '-');
				result.add(sb.toString());
				sb.setCharAt(i, '+');
				sb.setCharAt(i + 1, '+');
			}
		}
		return result;
	}
}
