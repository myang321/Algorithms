package leetcode;
public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int majorityElement(int[] num) {
		int major = -1;
		int cnt = 0;
		for (int i = 0; i < num.length; i++) {
			if (cnt == 0) {
				cnt++;
				major = num[i];
			} else if (major == num[i])
				cnt++;
			else
				cnt--;
		}
		return major;
	}

}
