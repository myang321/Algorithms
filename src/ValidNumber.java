public class ValidNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "6+1";
		System.out.println(isNumber(s));

	}

	public static boolean isNumber(String s) {
		s = s.trim();
		int flag = -2;
		// -2 before begin
		// -1 sign
		// 0 integer
		// 1 decimal point
		// 2 decimal
		// 3 e/ e-
		// 4 integer
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				if (flag == -2 || flag == -1 || flag == 0 || flag == 1
						|| flag == 2 || flag == 3 || flag == 4) {
					if (flag == -1 || flag == 1 || flag == 3)
						flag++;
					else if (flag == -2)
						flag = 0;
				} else
					return false;
			} else if (c == '.') {
				if (flag == 0 || flag == -1 || flag == -2) {
					flag = 1;
				} else
					return false;
			} else if (c == 'e') {
				if (flag == 0 || flag == 1 || flag == 2) {
					if (flag == 1 && i == 1)
						return false;
					flag = 3;
					if (i + 1 < s.length()
							&& (s.charAt(i + 1) == '-' || s.charAt(i + 1) == '+')) {
						i++;
					}
				} else
					return false;
			} else if (c == '-' || c == '+') {
				if (flag == -2)
					flag = -1;
				else
					return false;
			} else
				return false;
		}
		if (flag == -2 || flag == -1 || flag == 3)
			return false;
		if (flag == 1) {
			if (s.length() == 1)
				return false;
			else if (s.charAt(s.length() - 2) < '0'
					|| s.charAt(s.length() - 2) > '9')
				return false;
		}
		return true;
	}
}
