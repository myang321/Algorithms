package microsoft;

public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// space: O(1)
	// time: O(n)
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int idx = m + n - 1;
		m--;
		n--;
		while (m >= 0 && n >= 0) {
			if (nums1[m] > nums2[n])
				nums1[idx--] = nums1[m--];
			else
				nums1[idx--] = nums2[n--];
		}
		// no need for checking m, because nums1 is the result
		while (n >= 0)
			nums1[idx--] = nums2[n--];
	}

}
