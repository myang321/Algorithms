package leetcode;
public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelSheetColumnTitle e = new ExcelSheetColumnTitle();
		System.out.println(e.convertToTitle(26));
	}

	public String convertToTitle(int n) {
		StringBuffer sb = new StringBuffer();
		while (n > 0) {
			n--;
			int r = n % 26;
			char c = (char) ('A' + r);
			sb.insert(0, c);
			n /= 26;
		}
		return sb.toString();
	}

}
