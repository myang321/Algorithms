public class StringtoIntegeratoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int atoi(String str) {
		str = str.trim();
		int flag = 1;
		if (str == null || str.length() == 0)
			return 0;
		if (str.charAt(0) == '-') {
			flag = -1;
			str = str.substring(1);
		} else if (str.charAt(0) == '+')
			str = str.substring(1);
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		long num = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) < '0' || str.charAt(i) > '9')
				break;
			num *= 10;
			num += str.charAt(i) - '0';
			if (num > max) {
				if (flag < 0)
					return min;
				else
					return max;
			}
		}
		return (int) num*flag;
	}
}
