public class DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "101";
		numDecodings(s);

	}

	public static int numDecodings(String s) {
		if (s.length() == 0)
			return 0;
		char[] c = s.toCharArray();
		int[] f = new int[s.length()];
		int sum;
		if (c[0] == '0')
			return 0;
		if (s.length() == 1) {
			return 1;
		} else {
			f[0] = 1;
		}
		for (int i = 1; i < s.length(); i++) {
			sum = (c[i - 1] - '0') * 10 + c[i] - '0';
			if (c[i] == '0') {
				if (c[i - 1] > '2' || c[i - 1] == '0')
					return 0;
				else {
					if (i > 1)
						f[i] = f[i - 2];
					else
						f[i] = 1;
				}
			} else if (sum > 26) {

				f[i] = f[i - 1];
			} else if (sum < 10) {
				f[i] = f[i - 1];
			} else {
				if (i > 1)
					f[i] = f[i - 1] + f[i - 2];
				else
					f[i] = 2;
			}
		}
		return f[s.length() - 1];
	}
}
