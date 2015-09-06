import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class FractionToRecurringDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = fractionToDecimal(-1, -2147483648);
		System.out.println(s);
		Random rand = new Random();
		for (int i = 0; i < 0; i++) {
			int n = rand.nextInt(100);
			int d = rand.nextInt(100) + 1;
			System.out.println("n=" + n);
			System.out.println("d=" + d);
			System.out.println();
			System.out.println(fractionToDecimal(n, d));
		}
	}

	public static String fractionToDecimal(int n, int d) {
		boolean nega = (1. * n / d) >= 0 ? false : true;
		long n2 = n;
		long d2 = d;
		n2 = n2 >= 0 ? n2 : -n2;
		d2 = d2 >= 0 ? d2 : -d2;
		long intPart = n2 / d2;
		n2 %= d2;
		if (n2 == 0) {
			String sign = "";
			if (nega)
				sign = "-";
			return sign + intPart;
		}
		StringBuffer sb = new StringBuffer();
		HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
		int idx = -1;// recurring point
		int cnt = 0;
		while (n2 != 0) {
			if (hm.containsKey(n2)) {
				idx = hm.get(n2);
				break;
			}
			hm.put(n2, cnt);
			n2 *= 10;
			while (n2 < d2) {
				n2 *= 10;
				cnt++;
				sb.append("0");
			}
			int mul = (int) (n2 / d2);
			sb.append("" + mul);
			n2 %= d2;
			cnt++;
		}
		if (idx > -1) {
			while (idx - 1 >= 0
					&& sb.charAt(idx - 1) == sb.charAt(sb.length() - 1)) {
				idx--;
				sb.deleteCharAt(sb.length() - 1);
			}
			sb.insert(idx, "(");
			sb.append(")");

		}
		sb.insert(0, ".");
		sb.insert(0, "" + intPart);
		if (nega)
			sb.insert(0, "-");
		return sb.toString();
	}
}
