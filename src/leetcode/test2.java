import java.math.BigDecimal;
import java.util.Random;

public class test2 {

	public static volatile double b = 0;

	public static Random rand = new Random();

	public static void main(String[] args) {
		test2tt(4);
	}

	public static void test2tt(int len) {
		for (int i = 0; i < len / 2; i++) {
			for (int j = 0; j < len; j++) {
				System.out.println("i=" + i + " j=" + j);
				System.out.println("len-1-i=" + (len - 1 - i) + " j=" + j);
				System.out.println();
			}
			System.out.println("---");
		}
		System.out.println("in for 2");
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				System.out.println("i=" + i + "j=" + j);
			}
			System.out.println("---");
		}
	}

}
