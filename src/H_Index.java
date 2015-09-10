import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class H_Index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0)
			return 0;
		Arrays.sort(citations);
		int cnt = 0;
		for (int i = citations.length - 1; i >= 0; i--) {
			if (cnt < citations[i])
				cnt++;
			else
				return cnt;
		}
		return cnt;
	}
}
