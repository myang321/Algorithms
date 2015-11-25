package CC150.Chapter7;

import CC150.Chapter7.Card.Suit;
import static java.lang.System.out;

public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Card c = new Card(1, Suit.CLUBS);
		out.println(c.suit().value);

	}

}

class Card {
	public enum Suit {
		CLUBS(1), SPADES(2), HEARTS(3), DIAMONDS(4);
		int value;

		private Suit(int v) {
			value = v;
		}
	};

	private int card;
	private Suit suit;

	public Card(int r, Suit s) {
		card = r;
		suit = s;
	}

	public int value() {
		return card;
	}

	public Suit suit() {
		return suit;
	}
}