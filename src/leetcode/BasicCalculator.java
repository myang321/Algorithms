package leetcode;
import java.util.Scanner;

public class BasicCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "(1- 2)";
		calculate(str);
	}

	public static int calculate(String s) {
		s = s.replaceAll("[\\(\\) ]", "");
		s = s.replaceAll("[+]", " +");
		s = s.replaceAll("[-]", " -");
		int sum = 0;
		System.out.println(s);
		Scanner cin = new Scanner(s);
		while (cin.hasNext()) {
			sum += cin.nextInt();
		}
		return sum;
	}

}
