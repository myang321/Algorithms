package leetcode;

public class BullsandCows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BullsandCows b = new BullsandCows();
		b.getHint("12", "21");

	}

	public String getHint(String secret, String guess) {
		int bulls = 0;
		int cows = 0;
		int len = secret.length();
		// for 0-9
		int[] hash = new int[10];
		for (int i = 0; i < len; i++)
			hash[secret.charAt(i) - '0']++;
		// find bulls first
		for (int i = 0; i < len; i++) {
			char c = guess.charAt(i);
			if (secret.charAt(i) == c){
				bulls++;
				hash[c - '0']--;
			}
		}
		// then match cows
		for (int i = 0; i < len; i++) {
			char c = guess.charAt(i);
			if (secret.charAt(i) != c && hash[c - '0'] > 0) {
				cows++;
				hash[c - '0']--;
			}
		}
		return bulls + "A" + cows + "B";
	}
}
