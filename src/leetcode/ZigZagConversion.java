package leetcode;
public class ZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// char[][] c = new char[100][100];
		// System.out.println((int)c[0][0]);
		String s = "twckwuyvbihajbmhmodminftgpdcbquupwflqfiunpuwtigfwjtgzzcfofjpydjnzqysvgmiyifrrlwpwpyvqadefmvfshsrxsltbxbziiqbvosufqpwsucyjyfbhauesgzvfdwnloojejdkzugsrksakzbrzxwudxpjaoyocpxhycrxwzrpllpwlsnkqlevjwejkfxmuwvsyopxpjmbuexfwksoywkhsqqevqtpoohpd";
		String s2 = convert(s, 4);
		System.out.println(s2);
	}

	public static String convert(String s, int nRows) {
		int n = 1000;
		char[][] ch = new char[nRows][n];
		int c = 0;
		int r = 0;
		for (int i = 0; i < s.length(); i++) {
			ch[r][c] = s.charAt(i);
			if (c % 2 == 0) {
				r++;
				if (r == nRows) {
					c++;
					r = (nRows - 1) / 2;
				}
			} else {
				c++;
				r = 0;
			}
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < n; j++) {
				if (((int) ch[i][j]) != 0) {
					sb.append(ch[i][j]);
				}
			}
		}
		return sb.toString();
	}
}
