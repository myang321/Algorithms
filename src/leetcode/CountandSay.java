package leetcode;
public class CountandSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countAndSay(3);
	}

	public static String countAndSay(int n) {
		StringBuffer sbold = new StringBuffer("1");
		char old = '1';
		int cnt = 0;
		while (--n > 0) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < sbold.length(); i++) {
				if (old != sbold.charAt(i)) {
					sb.append(cnt);
					sb.append(old);
					old = sbold.charAt(i);
					cnt = 1;
				} else {
					cnt++;
				}
			}
			sbold = new StringBuffer(sb);
			if (cnt > 0) {
				sbold.append(cnt);
				sbold.append(old);
			}
			cnt = 0;
			old = sbold.charAt(0);
		}
		return sbold.toString();
	}
}
