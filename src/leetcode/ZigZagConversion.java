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
		char[] cs = s.toCharArray();
		int len = cs.length;
		StringBuffer[] sbs = new StringBuffer[nRows];
		for (int i = 0; i < nRows; i++)
			sbs[i] = new StringBuffer();
		int i = 0;
		while (i < len) {
			for (int j = 0; j < nRows && i < len; j++)
				sbs[j].append(cs[i++]);
			// as if it goes up vertically
			for (int j = nRows - 2; j > 0 && i < len; j--)
				sbs[j].append(cs[i++]);
		}
		for (int j = 1; j < nRows; j++)
			sbs[0].append(sbs[j]);
		return sbs[0].toString();
	}
}
