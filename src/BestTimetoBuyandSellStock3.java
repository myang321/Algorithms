public class BestTimetoBuyandSellStock3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 2, 6, 5, 0, 3 };
		System.out.println(maxProfit(arr));

	}

	public static int maxProfit(int[] prices) {
		if (prices.length == 0)
			return 0;
		int begin = 0;
		int end = 0;
		int endtmp = prices.length - 1;
		int max = prices[prices.length - 1];
		int val = 0;
		for (int i = prices.length - 1; i >= 0; i--) {
			if (max - prices[i] > val) {
				begin = i;
				end = endtmp;
				val = max - prices[i];
			}
			if (prices[i] > max) {
				endtmp = i;
				max = prices[i];
			}
		}
		int val2 = 0;
		if (prices.length - 1 > end) {
			max = prices[prices.length - 1];
			for (int i = prices.length - 1; i > end; i--) {
				if (max - prices[i] > val2) {
					val2 = max - prices[i];
				}
				if (prices[i] > max) {
					max = prices[i];
				}
			}
		}
		int val3 = 0;
		if (begin > 0) {
			max = prices[begin - 1];
			for (int i = begin - 1; i >= 0; i--) {
				if (max - prices[i] > val3) {
					val3 = max - prices[i];
				}
				if (prices[i] > max) {
					max = prices[i];
				}
			}
		}
		val3 = Math.max(val3, val2);
		int val4 = 0;
		max = prices[begin];
		for (int i = begin; i <= end; i++) {
			if (max - prices[i] > val4) {
				val4 = max - prices[i];
			}
			if (prices[i] > max) {
				max = prices[i];
			}
		}
		val4 = Math.max(val4, val3);
		return val + val4;
	}
}
