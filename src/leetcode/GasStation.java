package leetcode;
public class GasStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || cost == null || gas.length == 0 || cost.length == 0)
			return -1;
		int sum = 0;
		int total = 0;
		int idx = -1;
		for (int i = 0; i < gas.length; i++) {
			int tmp = gas[i] - cost[i];
			sum += tmp;
			total += tmp;
			if (sum < 0) {
				sum = 0;
				idx = i;
			}
		}
		return total >= 0 ? (idx + 1) % gas.length : -1;
	}

}
