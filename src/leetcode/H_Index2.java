package leetcode;
public class H_Index2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		H_Index2 hi2 = new H_Index2();
		int[] citations = { 0,3,3,3,3 };
		System.out.println(hi2.hIndex(citations));
	}

	public int hIndex(int[] citations) {
		if (citations == null)
			return 0;
		int len = citations.length;
		int lo = 0;
		int hi = len - 1;
		int result = 0;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			// System.out.println("mid=" + mid);
			// System.out.println("result=" + result);
			int cnt = len - mid;
			if (citations[mid] > cnt) {
				// potential longer sequence
				hi = mid - 1;
				result = cnt;
			} else if (citations[mid] < cnt) {
				// not valid
				lo = mid + 1;
			} else {
				result = cnt;
				return result;
			}
		}
		return result;
	}
}
