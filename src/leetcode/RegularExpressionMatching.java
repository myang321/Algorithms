package leetcode;

public class RegularExpressionMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegularExpressionMatching r = new RegularExpressionMatching();
		r.isMatch("aa", ".*");

	}

	private char[] s;
	private char[] p;
	private int lenS;
	private int lenP;

	public boolean isMatch(String s, String p) {
		this.s = s.toCharArray();
		this.p = p.toCharArray();
		lenS = s.length();
		lenP = p.length();
		return dfs(0, 0);
	}

	private boolean dfs(int idxS, int idxP) {
		if (idxS == lenS && idxP == lenP)
			return true;
		if (idxP == lenP)
			return false;
		// for *: match it or skip it
		if (idxP + 1 < lenP && p[idxP + 1] == '*') {
			if (idxS < lenS && (p[idxP] == '.' || s[idxS] == p[idxP]))
				return dfs(idxS + 1, idxP) || dfs(idxS, idxP + 2);
			else
				return dfs(idxS, idxP + 2);

		} else {
			// reach end of s, but still something in p other than *
			if (idxS == lenS)
				return false;
			if (p[idxP] == '.' || p[idxP] == s[idxS])
				return dfs(idxS + 1, idxP + 1);
			else
				return false;
		}
	}
}
