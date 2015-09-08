import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getRow(2);

	}

	public static List<Integer> getRow(int rowIndex) {
		Integer a[] = new Integer[rowIndex + 1];
		Integer b[] = new Integer[rowIndex + 1];
		for (int i=0;i<rowIndex+1;i++){
			a[i]=0;
			b[i]=0;
		}
		a[0] = 1;
		for (int i = 1; i <= rowIndex; i++) {
			b[0] = 1;
			for (int j = 1; j <= i; j++) {
				b[j] = a[j - 1] + a[j];
			}
			for (int j = 0; j <= i; j++) {
				a[j] = b[j];
			}
		}
		List<Integer> arr = Arrays.asList(a);
		return arr;
	}

}
