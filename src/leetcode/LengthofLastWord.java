public class LengthofLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lengthOfLastWord(new String("a"));

	}

	public static int lengthOfLastWord(String s) {
		if (s == null || s.isEmpty())
			return 0;
		int i;
		for (i = 0; i < s.length(); i++)
			if (s.charAt(i) != ' ')
				break;
		if (i == s.length())
			return 0;
		i = s.length() - 1;
		int idx = 0;
		while (s.charAt(i) == ' ')
			i--;
		idx = i;
		for (; i >= 0; i--)
			if (s.charAt(i) == ' ')
				break;
		return idx - i;
	}

}
