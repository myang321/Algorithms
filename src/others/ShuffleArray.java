package others;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {

	public static void main(String[] args) {
		// System.out.println("Hello, world");
		int[] array = { 1, 2, 3, 4, 5 };
		Random random = new Random();
		int len = array.length;
		for (int i = 0; i < array.length - 1; i++) {
			int a = i + 1 + random.nextInt(len - i - 1);
			int temp;
			temp = array[a];
			array[a] = array[i];
			array[i] = temp;
			System.out.println(i + " " + a);
		}
		System.out.println(Arrays.toString(array));
	}

}
