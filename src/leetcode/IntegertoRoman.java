public class IntegertoRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String intToRoman(int num) {
		int[] r_num = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] r_str = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };
		int idx = 0;
		StringBuffer sb = new StringBuffer();
		while (num != 0) {
			int time = num / r_num[idx];
			num -= time * r_num[idx];
			for (int i = 0; i < time; i++) {
				sb.append(r_str[idx]);
			}
			idx++;
		}
		return sb.toString();
	}
}
