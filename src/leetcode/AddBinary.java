public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddBinary a = new AddBinary();
		a.addBinary("1", "1");
	}

	public String addBinary(String a, String b) {
		StringBuffer c = new StringBuffer("");
		a = new StringBuilder(a).reverse().toString();
		b = new StringBuilder(b).reverse().toString();
		int ia, ib;
		int carry = 0;
		int sum;
		int len = Math.max(a.length(), b.length());
		for (int i = 0; i < len; i++) {
			if (i >= a.length())
				ia = 0;
			else
				ia = a.charAt(i) - '0';
			if (i >= b.length())
				ib = 0;
			else
				ib = b.charAt(i) - '0';
			sum = carry + ia + ib;
			if (sum < 2)
				carry = 0;
			else
				carry = 1;
			c.insert(0, (char) ('0' + (sum % 2)));
		}
		if (carry == 1)
			c.insert(0, '1');
		return c.toString();
	}

	public String addBinary2(String a, String b) {
		StringBuffer a1 = new StringBuffer(a);
		StringBuffer b1 = new StringBuffer(b);
		StringBuffer result = new StringBuffer();
		a1 = a1.reverse();
		b1 = b1.reverse();
		int c = 0;
		int sum = 0;
		if (a1.length() >= b1.length()) {
			for (int i = 0; i < b1.length(); i++) {
				sum = (a1.charAt(i) - '0' + b1.charAt(i) - '0' + c);
				c = sum / 2;
				sum = sum % 2;
				result.append(sum);
			}
			for (int j = b1.length(); j < a1.length(); j++) {
				if (a1.charAt(j) - '0' + c > 1) {
					sum = (a1.charAt(j) - '0' + c) % 2;
					c = (a1.charAt(j) - '0' + c) / 2;
					result.append(sum);
				} else {
					result.append(a1.charAt(j)+c);
					c=0;
				}

			}
			if (c != 0) {
				result.append(c);
			}
		} else {
			for (int i = 0; i < a1.length(); i++) {
				if (a1.charAt(i) - '0' + b1.charAt(i) - '0' + c > 1) {
					sum = (a1.charAt(i) - '0' + b1.charAt(i) - '0' + c) % 2;
					c = (a1.charAt(i) - '0' + b1.charAt(i) - '0' + c) / 2;
				} else {
					sum = (a1.charAt(i) - '0' + b1.charAt(i) - '0' + c);
					c = 0;
				}
				result.append(sum);
			}
			for (int j = a1.length(); j < b1.length(); j++) {
				if (b1.charAt(j) - '0' + c > 1) {
					sum = (b1.charAt(j) - '0' + c) % 2;
					c = (b1.charAt(j) - '0' + c) / 2;
					result.append(sum);
				} else {
					result.append(b1.charAt(j)+c);
					c=0;
				}
			}
			if (c != 0) {
				result.append(c);
			}
		}

		return result.reverse().toString();
	}
}
