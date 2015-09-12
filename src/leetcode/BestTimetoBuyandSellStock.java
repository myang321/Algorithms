package leetcode;
public class BestTimetoBuyandSellStock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int maxProfit(int[] prices) {
		if (prices.length==0)
			return 0;
		int max = prices[prices.length - 1];
		int val = 0;
		for (int i = prices.length - 1; i >= 0; i--) {
			if (max - prices[i] > val) {
				val = max - prices[i];
			}
			if (prices[i] > max)
				max = prices[i];
		}
		return val;
	}

}
