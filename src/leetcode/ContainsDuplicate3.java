import java.util.HashMap;

public class ContainsDuplicate3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 3, 1 };
		System.out.println(containsNearbyAlmostDuplicate(nums, 1, 1));

	}

	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k <= 0 || t < 0)
			return false;
		HashMap<Long, Long> hs = new HashMap<Long, Long>();
		for (long i = 0; i < nums.length; i++) {
			long bucket = nums[(int) i] / (((long) t) + 1);
			for (long j = (bucket - 1); j <= bucket + 1; j++) {
				if (hs.containsKey(j)) {
					long num = hs.get(j);
					if (Math.abs(num - nums[(int) i]) <= t)
						return true;
				}
			}
			hs.put(bucket, (long) nums[(int) i]);
			if (i >= k) {
				long oldBucket = nums[(int) (i - k)] / (t + 1);
				hs.remove(oldBucket);
			}
		}
		return false;
	}

}
